package com.example.shoepping.use_case.buy_user_used_shoe.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;

import java.io.IOException;

public interface IBuyUserUsedShoeView {
    void onLabelsUpdate(int shoeSale, String shoeBrand, String shoeItem, double shoePrice, int shoeSize, String shoeUsername, String shoeCondition);

    void onConfirmError(MessageBean message, CodeBean code);

    void onConfirmSuccess() throws IOException;
}
