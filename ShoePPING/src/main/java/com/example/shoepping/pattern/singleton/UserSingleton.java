package com.example.shoepping.pattern.singleton;

import com.example.shoepping.model.user.User;

public class UserSingleton {

    // Unica istanza della classe
    private static UserSingleton instance = null;

    // Costruttore invisibile
    private UserSingleton(){
    }

    public static UserSingleton getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    // Variable of type User and boolean
    private User user;
    private boolean isChecked;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
