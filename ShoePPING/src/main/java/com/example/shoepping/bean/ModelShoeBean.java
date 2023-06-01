package com.example.shoepping.bean;

public class ModelShoeBean {
    private String modelShoe;
    private int isValid;

    public ModelShoeBean() {
        // empty constructor
    }

    public String getModelShoe() {
        return modelShoe;
    }

    public void setModelShoe(String modelShoe) {
        this.modelShoe = modelShoe;
        isValid();
    }
    public int getIsValid() {
        return isValid;
    }
    private void isValid(){
        if (modelShoe.isEmpty())
            this.isValid = 1;
        else this.isValid = -1;
    }


}
