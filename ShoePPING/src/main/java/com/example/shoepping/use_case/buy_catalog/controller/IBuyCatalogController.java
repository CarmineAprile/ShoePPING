package com.example.shoepping.use_case.buy_catalog.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyCatalogController {

    void getCatalog() throws SQLException, IOException, ClassNotFoundException;

    void setFilter(ModelShoeBean item, BrandBean brand, SizeShoeBean size, ConditionBean condition, PriceBean price) throws SQLException, IOException, ClassNotFoundException, ManageException, CsvValidationException;
}
