package com.example.shoepping.model.shoe;
public class Shoe implements IShoe{

    private final String id;
    private String amount;
    private String price;
    private String size;


    public Shoe(String id, String price) {
        this.id = id;
        this.price = price;
    }

    public Shoe(String id, String size, String amount) {
        this.id = id;
        this.size = size;
        this.amount = amount;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getAmount() {
        return this.amount;
    }

    @Override
    public String getPrice() {
        return this.price;
    }
    @Override
    public String getSize() {
        return size;
    }

}
