package com.example.shoepping.use_case.administrator.controller;

import com.example.shoepping.model.shoe.Shoe;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;

public class AdministratorController implements IAdministratorController{

    IAdministratorView administratorView;

    public AdministratorController(IAdministratorView administratorView){
        this.administratorView = administratorView;
    }

    @Override
    public void onUpdateAmount(String id, String amount) {
        Shoe shoe = new Shoe(id, amount, "0");

        switch (shoe.isValid()){
            // 0. check for ID is empty
            // 1. check for ID is int
            // 2. check for amount is empty
            // 3. check for amount is int
            case 0 -> administratorView.onUpdateAmountError("Please insert an ID", 0);
            case 1 -> administratorView.onUpdateAmountError("Please insert a valid ID format", 1);
            case 2 -> administratorView.onUpdateAmountError("Please insert an amount", 2);
            case 3 -> administratorView.onUpdateAmountError("Please insert a valid amount format", 3);
            default -> {
                // chiama dao per update dei dati
            }
        }
    }

    @Override
    public void onUpdatePrice(String id, String price) {
        Shoe shoe = new Shoe(id, "0", price);

        switch (shoe.isValid()){
            // 0. check for ID is empty
            // 1. check for ID is int
            // 4. check for price is empty
            // 5. check for price is numeric
            case 0 -> administratorView.onUpdatePriceError("Please insert an ID", 0);
            case 1 -> administratorView.onUpdatePriceError("Please insert a valid ID format", 1);
            case 4 -> administratorView.onUpdatePriceError("Please insert a price", 4);
            case 5 -> administratorView.onUpdatePriceError("Please insert a valid price format", 5);
            default -> {
                // chiama dao per update dei dati
            }
        }
    }
}
