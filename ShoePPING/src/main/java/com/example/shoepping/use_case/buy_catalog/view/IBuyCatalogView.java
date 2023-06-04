package com.example.shoepping.use_case.buy_catalog.view;

import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyCatalogView {
    void setShoeLabel(ModelShoeBean item);

    void onApplyFilterError() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
