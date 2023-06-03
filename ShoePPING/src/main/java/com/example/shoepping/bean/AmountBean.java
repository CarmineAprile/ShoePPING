package com.example.shoepping.bean;

public class AmountBean {
    private String amount;
    private int isValid;

    public AmountBean() {
        // empty constructor
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if(amount.isEmpty())
            this.isValid = 2;
        else if(isNotAnInt(amount))
            this.isValid = 3;
        else this.isValid = -1;
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