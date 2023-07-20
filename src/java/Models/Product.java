/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;


public class Product {
    private int idProduct;
    private String name;
    private String description;
    private double price;
    private String image;
    private int idCatory;
    private int quantity;
    private String createdAt;
  
    public Product() {
    }
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int idProduct, String name, String description, double price, String image, int idCatory, int quantiry,String date) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.idCatory = idCatory;
        this.quantity = quantiry;
        this.createdAt=date;
      
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }



    
    
    
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getIdCatory() {
        return idCatory;
    }

    public void setIdCatory(int idCatory) {
        this.idCatory = idCatory;
    }


    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price=" + price + ", image=" + image  + ", idCatory=" + idCatory + '}';
    }

   
}
