package com.example.shoepping.use_case.administrator.view;

public interface IAdministratorView {

    void onUpdateAmountError(String message, int errorCode);
    void onUpdateAmountSuccess();

    void onUpdatePriceError(String message, int errorCode);
    void onUpdatePriceSuccess();
}
