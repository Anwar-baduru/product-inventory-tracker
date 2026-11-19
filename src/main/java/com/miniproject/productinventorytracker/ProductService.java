package com.miniproject.productinventorytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addProduct(Product product) {
        String sql=" INSERT INTO product (product_name, price, category) VALUES (?,?,?)";
        int rowsAffected=jdbcTemplate.update(sql,
                product.getProductName(),
                product.getPrice(),
                product.getCategory());
        return rowsAffected > 0;
    }
}
