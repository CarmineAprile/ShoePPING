package com.example.shoepping.use_case.administrator.controller;

import com.example.shoepping.bean.AmountBean;
import com.example.shoepping.bean.IdBean;
import com.example.shoepping.bean.PriceBean;
import com.example.shoepping.bean.SizeShoeBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IAdministratorController {
    void onUpdateAmount(IdBean idAmount, AmountBean amount, SizeShoeBean size) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void onUpdatePrice(IdBean idAmount, PriceBean price) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    String getReport() throws SQLException, IOException, ClassNotFoundException;
}
