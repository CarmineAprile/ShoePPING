package com.example.shoepping.bean;

public class SizeShoeBean {
    private String sizeShoe;
    private int isValid;



    public SizeShoeBean() {
        // empty constructor
    }
    public String getSizeShoe() {
        return sizeShoe;
    }
    public void setSizeShoe(String sizeShoe) {
        this.sizeShoe = sizeShoe;
        isValid();
    }
    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if(sizeShoe.isEmpty())
            this.isValid = 5;
        else if(!isASize(sizeShoe))
            this.isValid = 6;
        else if(Integer.parseInt(sizeShoe) < 30 || Integer.parseInt(sizeShoe) >60)
            this.isValid = 7;
        else this.isValid = -1;

    }

    private boolean isASize(String size){
        try{
            Integer.parseInt(size);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
