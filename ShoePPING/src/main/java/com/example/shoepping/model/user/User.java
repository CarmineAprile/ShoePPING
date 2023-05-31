package com.example.shoepping.model.user;


public class User implements IUser {

    private String username;
    private String pass;
    private String email;

    public User(String username, String pass, String email) {
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
        this.email = "";
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return pass;
    }
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String pass) {
        this.pass = pass;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

}
