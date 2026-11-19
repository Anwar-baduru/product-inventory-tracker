package com.miniproject.productinventorytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
