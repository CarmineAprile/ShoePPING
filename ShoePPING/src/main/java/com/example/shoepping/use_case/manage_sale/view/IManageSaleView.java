package com.example.shoepping.use_case.manage_sale.view;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;

public interface IManageSaleView {
    void setNotAvailableCSV();

    void setSaleButton(SaleBean s, ItemDataBean itemData);
}
