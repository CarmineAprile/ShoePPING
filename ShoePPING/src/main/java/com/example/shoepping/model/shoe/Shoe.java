package com.example.shoepping.model.shoe;

import static com.example.shoepping.ValidationNumeric.isNotAPrice;

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

    @Override
    public int isValidAmount() {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is int
        // 4. check for size is empty
        // 5. check for size is int

        if(getID().isEmpty()){
            return 0;
        }else if(isNotAnInt(getID())){
            return 1;
        }else if(getAmount().isEmpty()){
            return 2;
        }else if(isNotAnInt(getAmount())){
            return 3;
        }else if(getSize().isEmpty()){
            return 4;
        }else if(isNotAnInt(getSize())){
            return 5;
        }else return -1;
    }

    @Override
    public int isValidPrice() {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for price is empty
        // 3. check for price is numeric

        if(getID().isEmpty()){
            return 0;
        }else if(isNotAnInt(getID())){
            return 1;
        }else if(getPrice().isEmpty()){
            return 2;
        }else if(isNotAPrice(getPrice())){
            return 3;
        }else return -1;
    }

    private boolean isNotAnInt(String value){
        try{
            Integer.parseInt(value);
            return false;
        }catch(Exception e){
            return true;
        }
    }
}
