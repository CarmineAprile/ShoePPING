package com.example.shoepping.bean;

import com.example.shoepping.ValidationCard;

public class OrderVecBean {

    private int isValid;
    private String modelShoe;
    private String priceShoe;
    private String size;
    private String address;
    private String cardID;
    private String cardDate;
    private String cardCVC;

    public OrderVecBean() {
        // empty constructor
    }

    public String getModelShoeVec() {
        return modelShoe;
    }

    public void setModelShoeVec(String modelShoe) {
        this.modelShoe = modelShoe;
    }

    public String getPriceShoeVec() {
        return priceShoe;
    }

    public void setPriceShoeVec(String priceShoe) {
        this.priceShoe = priceShoe;
    }

    public String getSizeVec() {
        return size;
    }

    public void setSizeVec(String size) {
        this.size = size;
    }

    public String getAddressVec() {
        return address;
    }

    public void setAddressVec(String address) {
        this.address = address;
    }

    public void setCardIDVec(String cardID) {
        this.cardID = cardID;
    }

    public void setCardDateVec(String cardDate) {
        this.cardDate = cardDate;
    }

    public void setCardCVCVec(String cardCVC) {
        this.cardCVC = cardCVC;
    }

    public int getIsValid() {
        return isValid;
    }

    public void isValid(){
        if (size.equals("Select size"))
            this.isValid = 0;
        else if(address.isEmpty())
            this.isValid = 1;
        else if(!(ValidationCard.valCardID(cardID)))
            this.isValid = 2;
        else if(!ValidationCard.valCardDate(cardDate))
            this.isValid = 3;
        else if(!(ValidationCard.valCardCVC(cardCVC)))
            this.isValid = 4;
        else this.isValid = -1;
    }
}
