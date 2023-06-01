package com.example.shoepping.use_case.sell_user_shoe.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;

import java.io.IOException;

public interface ISellUserShoeView {
    void onInsertSaleError(MessageBean message, CodeBean code);
    void onInsertSaleSuccess() throws IOException;

    void onRecommendedPriceCalculateError(MessageBean message);
    void onRecommendedPriceCalculateSuccess(String price, String condition);
}
