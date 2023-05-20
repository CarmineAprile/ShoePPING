package com.example.shoepping.use_case.sell_user_shoe.view;

import java.io.IOException;

public interface ISellUserShoeView {
    void onInsertSaleError(String message, int code);
    void onIsertSaleSuccess() throws IOException;

    void onReccomendedPriceCalculateError(String message);
    void onReccomendedPriceCalculateSuccess(String price, String condition);
}
