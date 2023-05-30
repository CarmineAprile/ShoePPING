package com.example.shoepping.bean;

import static com.example.shoepping.ValidationEmail.valEmail;

public class EmailBean {
    private String email;
    private int isValid;

    public EmailBean() {
        // Empty constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if (email.isEmpty())
            this.isValid = 5;
        else if (!valEmail(email))
            this.isValid = 6;
        else if(email.length() > 40)
            this.isValid = 30;
        else this.isValid = -1;
    }
}
