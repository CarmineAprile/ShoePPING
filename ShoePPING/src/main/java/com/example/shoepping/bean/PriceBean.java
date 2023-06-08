package com.example.shoepping.bean;

import static com.example.shoepping.ValidationNumeric.isNotAPrice;

public class PriceBean {
    private String price;
    private int isValid;

    public PriceBean() {
        // empty constructor
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }


    private void isValid(){
        if (price.isEmpty())
            this.isValid = 2;
        else if(isNotAPrice(price))
            this.isValid = 3;
        else if(Double.parseDouble(price) < 0)
            this.isValid = 4;
        else this.isValid = -1;
    }
}
