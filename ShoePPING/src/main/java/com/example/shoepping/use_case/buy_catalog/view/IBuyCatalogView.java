package com.example.shoepping.use_case.buy_catalog.view;

import com.example.shoepping.bean.ModelShoeBean;

public interface IBuyCatalogView {
    void setShoeLabel(ModelShoeBean item);

    void onApplyFilterError();
}
