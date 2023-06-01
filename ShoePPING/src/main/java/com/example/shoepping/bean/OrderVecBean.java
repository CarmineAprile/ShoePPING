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

    public String getModelShoeOrderVec() {
        return modelShoe;
    }

    public void setModelShoeOrderVec(String modelShoe) {
        this.modelShoe = modelShoe;
    }

    public String getPriceShoeOrderVec() {
        return priceShoe;
    }

    public void setPriceShoeOrderVec(String priceShoe) {
        this.priceShoe = priceShoe;
    }

    public String getSizeOrderVec() {
        return size;
    }

    public void setSizeOrderVec(String size) {
        this.size = size;
    }

    public String getAddressOrderVec() {
        return address;
    }

    public void setAddressOrderVec(String address) {
        this.address = address;
    }

    public void setCardIDOrderVec(String cardID) {
        this.cardID = cardID;
    }

    public void setCardDateOrderVec(String cardDate) {
        this.cardDate = cardDate;
    }

    public void setCardCVCOrderVec(String cardCVC) {
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
