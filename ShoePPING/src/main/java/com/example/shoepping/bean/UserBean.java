package com.example.shoepping.bean;

import com.example.shoepping.model.user.User;

public class UserBean {
    private User user;

    public UserBean() {
        // empty constructor
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
