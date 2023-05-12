package com.example.shoepping.use_case.buy_user_used_shoe.view;

import java.io.IOException;

public interface IBuyUserUsedShoeView {
    void onLabelsUpdate(int shoeSale, String shoeBrand, String shoeItem, double shoePrice, int shoeSize, String shoeUsername, String shoeCondition);

    void onConfirmError(String message, int code);

    void onConfirmSuccess() throws IOException;
}
