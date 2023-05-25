package com.example.shoepping.model.shoe;

import static com.example.shoepping.ValidationNumeric.isNotAPrice;

public class Shoe implements IShoe{

    private final String id;
    private final String amount;
    private final String price;


    public Shoe(String id, String amount, String price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
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
    public int isValid() {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is int
        // 4. check for price is empty
        // 5. check for price is numeric

        if(getID().isEmpty()){
            return 0;
        }else if(isNotAnInt(getID())){
            return 1;
        }else if(getAmount().isEmpty()){
            return 2;
        }else if(isNotAnInt(getAmount())){
            return 3;
        }else if(getPrice().isEmpty()){
            return 4;
        }else if(isNotAPrice(getPrice())){
            return 5;
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
