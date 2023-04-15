package com.example.shoepping.model.user;

public interface IUser {

    String getUsername();
    String getPassword();
    String getEmail();
    int isValid();
    void setUsername(String username);
    void setPassword(String password);
    void setEmail(String email);
}
