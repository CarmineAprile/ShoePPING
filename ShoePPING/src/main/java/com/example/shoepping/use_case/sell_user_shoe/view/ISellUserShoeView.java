package com.example.shoepping.use_case.sell_user_shoe.view;

public interface ISellUserShoeView {
    void onInsertSaleError(String message, int code);
    void onIsertSaleSuccess();

    void onReccomendedPriceCalculateError(String message);
    void onReccomendedPriceCalculateSuccess(String price, String condition);
}
