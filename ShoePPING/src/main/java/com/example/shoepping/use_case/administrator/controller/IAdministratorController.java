package com.example.shoepping.use_case.administrator.controller;

public interface IAdministratorController {
    void onUpdateAmount(String idAmount, String amount);

    void onUpdatePrice(String idAmount, String price);
}
