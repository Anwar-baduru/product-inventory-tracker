package com.miniproject.productinventorytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Product> rowMapper = (rs,rowNum) -> {
        Product item = new Product();
        item.setProductName(rs.getString("product_name"));
        item.setPrice(rs.getDouble("price"));
        item.setCategory(rs.getString("category"));
        return item;
    };

    public boolean addProduct(Product product) {
        String sql=" INSERT INTO product (product_name, price, category) VALUES (?,?,?)";
        int rowsAffected=jdbcTemplate.update(sql,
                product.getProductName(),
                product.getPrice(),
                product.getCategory());
        return rowsAffected > 0;
    }

    // return only products that matching the category. If category is null/empty, return all products.
    public List<Product> getProducts(String category)
    {
        String sql;
        if(category != null && !category.isEmpty())
        {
            sql=" SELECT product_name, price, category FROM product WHERE category = ? ";
            return jdbcTemplate.query(sql, rowMapper, category);
        }
        sql=" SELECT product_name, price, category FROM product ";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // returns a single product that matches the id
    public Product getProductById(long id)
    {
        String sql=" SELECT product_name, price, category FROM product WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // Update price of a specific product
    public boolean updateProductPrice(long id, double price)
    {
        String sql=" UPDATE product SET price = ? WHERE id = ? ";
        int rowAffected = jdbcTemplate.update(sql, price, id);
        return rowAffected > 0;
    }

    // Delete a product that matches the id
    public boolean deleteProductById(long id)
    {
        String sql=" DELETE FROM product WHERE id = ? ";
        int rowAffected = jdbcTemplate.update(sql, id);
        return rowAffected > 0;
    }
}
