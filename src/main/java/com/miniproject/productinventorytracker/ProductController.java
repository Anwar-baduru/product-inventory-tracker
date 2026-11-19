package com.miniproject.productinventorytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody Product product)
    {
        boolean success = productService.addProduct(product);
        if(success)
        {
            return product.getProductName()+" is successfully added to the inventory. ";
        }
        return "PRODUCT : "+product.getProductName()+" is NOT ADDED to the inventory";
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(value = "category",required = false) String category)
    {
        return productService.getProducts(category);
    }
}
