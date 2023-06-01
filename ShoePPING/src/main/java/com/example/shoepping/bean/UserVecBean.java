package com.example.shoepping.bean;

import com.example.shoepping.ValidationCard;

public class UserVecBean {
    private String address;
    private String cardID;
    private String cardDate;
    private String cardCVC;
    private String condition;

    private int isValid;

    public UserVecBean() {
        // empty constructor
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

    public String getConditionVec() {
        return condition;
    }

    public void setConditionVec(String condition) {
        this.condition = condition;
    }


    public int getIsValid() {
        return isValid;
    }

    public void isValid(){
        if (address.isEmpty())
            this.isValid = 0;
        else if(!(ValidationCard.valCardID(cardID)))
            this.isValid = 1;
        else if(!ValidationCard.valCardDate(cardDate))
            this.isValid = 2;
        else if(!(ValidationCard.valCardCVC(cardCVC)))
            this.isValid = 3;
        else this.isValid = -1;
    }


}
