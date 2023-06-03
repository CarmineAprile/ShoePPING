package com.example.shoepping.use_case.manage_sale.view;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IManageSaleView {
    void setNotAvailableCSV() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void setSaleButton(SaleBean s, ItemDataBean itemData);
}
