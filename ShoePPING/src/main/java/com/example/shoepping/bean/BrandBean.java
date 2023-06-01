package com.example.shoepping.bean;

public class BrandBean {
    private String brand;
    private int isValid;

    public BrandBean() {
        // empty constructor
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }


    private void isValid(){
        if(brand.isEmpty())
            this.isValid = 0;
        else this.isValid = -1;
    }
}
