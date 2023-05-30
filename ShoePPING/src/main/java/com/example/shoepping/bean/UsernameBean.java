package com.example.shoepping.bean;

public class UsernameBean {
    private String username;
    private int isValid;

    public UsernameBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if (username.isEmpty())
            this.isValid = 0;
        else if(username.length() > 20)
            this.isValid = 10;
        else this.isValid = -1;
    }
}
