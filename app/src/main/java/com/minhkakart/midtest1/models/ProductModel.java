package com.minhkakart.midtest1.models;

public class ProductModel {
    private int id = -1;
    private String name;
    private String description;
    private int price;
    private String imageName;

    public ProductModel(int id, String name, String description, int price, String imageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public ProductModel(String name, String description, int price, String imageName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImageName() {
        return imageName;
    }
}
