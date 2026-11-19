
package com.miniproject.productinventorytracker;

public class Product  // blueprint/template class
{
    private String productName;
    private double price;
    private String category;

    // getter and setter for product name
    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String productName)
    {
        this.productName=productName;
    }

    // getter and setter for price
    public double getPrice() { return price; }
    public void setPrice(double price)
    {
        this.price=price;
    }

    // getter and setter for category
    public String getCategory() { return category; }
    public void setCategory(String category)
    {
        this.category=category;
    }
}
