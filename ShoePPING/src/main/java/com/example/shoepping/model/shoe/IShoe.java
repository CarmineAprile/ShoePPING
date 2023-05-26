package com.example.shoepping.model.shoe;

public interface IShoe {
    String getID();
    String getAmount();
    String getPrice();

    String getSize();

    int isValidAmount();
    int isValidPrice();
}
