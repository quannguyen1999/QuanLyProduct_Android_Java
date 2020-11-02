package com.example.myapplication.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String maProduct;
    private String name;
    private String content;
    private int price;
    private int image;

    public Product(String maProduct, String name, String content, int price, int image) {
        this.maProduct = maProduct;
        this.name = name;
        this.content = content;
        this.price = price;
        this.image = image;
    }

    public Product() {
    }

    public String getMaProduct() {
        return maProduct;
    }

    public void setMaProduct(String maProduct) {
        this.maProduct = maProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "maProduct='" + maProduct + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", image=" + image +
                '}';
    }
}
