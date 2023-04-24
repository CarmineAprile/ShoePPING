package com.example.shoepping.use_case.buy_shoe.view;

import java.io.IOException;

public interface IBuyShoeView {
    void onDisable(int i);

    void onConfirmSuccess() throws IOException;
    void onConfirmError(String message, int code);
}
