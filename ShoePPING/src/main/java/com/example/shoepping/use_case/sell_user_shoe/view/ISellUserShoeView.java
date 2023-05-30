package com.example.shoepping.use_case.sell_user_shoe.view;

import java.io.IOException;

public interface ISellUserShoeView {
    void onInsertSaleError(String message, int code);
    void onInsertSaleSuccess() throws IOException;

    void onRecommendedPriceCalculateError(String message);
    void onRecommendedPriceCalculateSuccess(String price, String condition);
}
