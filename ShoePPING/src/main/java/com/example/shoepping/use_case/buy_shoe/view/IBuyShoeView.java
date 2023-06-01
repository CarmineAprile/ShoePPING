package com.example.shoepping.use_case.buy_shoe.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.SizeShoeBean;

import java.io.IOException;

public interface IBuyShoeView {
    void onDisable(SizeShoeBean i);

    void onConfirmSuccess() throws IOException;
    void onConfirmError(MessageBean message, CodeBean code);
}
