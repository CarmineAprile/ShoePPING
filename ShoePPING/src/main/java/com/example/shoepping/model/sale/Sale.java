package com.example.shoepping.model.sale;
public class Sale implements ISale{

    private String brand;
    private String item;
    private  String price;
    private String condition;
    private String size;
    private String seller;

    public Sale(String brand, String item, String price, String condition, String size) {
        this.brand = brand;
        this.item = item;
        this.price = price;
        this.condition = condition;
        this.size = size;
    }

    public Sale(String brand, String item, String price, String condition, String size, String seller) {
        this.brand = brand;
        this.item = item;
        this.price = price;
        this.condition = condition;
        this.size = size;
        this.seller = seller;
    }

    public Sale(String price, String condition){
        this.price = price;
        this.condition = condition;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getItem() {
        return item;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public String getSize() {
        return size;
    }
    @Override
    public String getSeller() {
        return seller;
    }


}
