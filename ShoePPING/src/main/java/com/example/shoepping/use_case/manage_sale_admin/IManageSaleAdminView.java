package com.example.shoepping.use_case.manage_sale_admin;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;

public interface IManageSaleAdminView {
    void setSaleButton(SaleBean s, ItemDataBean itemData);
}
