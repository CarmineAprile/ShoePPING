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

    public String getAddressUserVec() {
        return address;
    }

    public void setAddressUserVec(String address) {
        this.address = address;
    }

    public void setCardIDUserVec(String cardID) {
        this.cardID = cardID;
    }

    public void setCardDateUserVec(String cardDate) {
        this.cardDate = cardDate;
    }

    public void setCardCVCUserVec(String cardCVC) {
        this.cardCVC = cardCVC;
    }

    public String getConditionUserVec() {
        return condition;
    }

    public void setConditionUserVec(String condition) {
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
