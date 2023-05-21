package com.example.shoepping.use_case.manage_sale.view;

import java.util.List;

public interface IManageSaleView {
    void setNotAvailableCSV();

    void setSaleButton(String s, List<String> itemData);
}
