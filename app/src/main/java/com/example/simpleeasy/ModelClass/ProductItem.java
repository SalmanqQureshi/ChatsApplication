package com.example.simpleeasy.ModelClass;

public class ProductItem {
    int id;
    String name;
    Integer images;
    int price;
    String quantity;

    public ProductItem() {

    }

    public ProductItem(int id, String name, Integer images,int price, String quantity) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImages() {
        return images;
    }

    public void setImages(Integer images) {
        this.images = images;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
