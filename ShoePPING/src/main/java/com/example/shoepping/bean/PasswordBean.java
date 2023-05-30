package com.example.shoepping.bean;

public class PasswordBean {

    private String password;
    private int isValid;

    public PasswordBean() {
        // empty constructor
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if (password.isEmpty())
            this.isValid = 1;
        else if (password.length() <= 6)
            this.isValid = 2;
        else if(password.length() > 20)
            this.isValid = 20;
        else this.isValid = -1;
    }
}
