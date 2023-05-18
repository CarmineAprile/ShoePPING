package com.example.shoepping.use_case.sell_user_shoe.view;

import com.example.shoepping.model.sale.Sale;

public interface ISellUserShoeView {
    void onInsertSaleError(String message, int code);
    void onIsertSaleSuccess();

    void onReccomendedPriceCalculateError(String message, int code);
    void onReccomendedPriceCalculateSuccess(Sale sale);
}
