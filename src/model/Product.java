package model;

import java.io.Serializable;

/**
 * Class Product
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double price;
    private Integer quantity;

    //--- Empty Constructor ---
    public Product() {
    }

    //--- Constructor ---
    public Product(String name, Double price, Integer quantity) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //--- Getters and Setters ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
