package com.example.shoepping.use_case.administrator.controller;

import com.example.shoepping.dao.report_dao.ReportDao;
import com.example.shoepping.dao.update_dao.UpdateDao;
import com.example.shoepping.model.report.ReportList;
import com.example.shoepping.model.shoe.Shoe;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;

import java.io.IOException;
import java.sql.SQLException;

public class AdministratorController implements IAdministratorController{

    IAdministratorView administratorView;

    public AdministratorController(IAdministratorView administratorView){
        this.administratorView = administratorView;
    }

    @Override
    public void onUpdateAmount(String id, String amount, String size) throws SQLException, IOException, ClassNotFoundException {
        Shoe shoe = new Shoe(id, size, amount);

        switch (shoe.isValidAmount()){
            // 0. check for ID is empty
            // 1. check for ID is int
            // 2. check for amount is empty
            // 3. check for amount is int
            // 4. check for size is empty
            // 5. check for size is int
            case 0 -> administratorView.onUpdateAmountError("Please insert an ID", 0);
            case 1 -> administratorView.onUpdateAmountError("Please insert a valid ID format", 1);
            case 2 -> administratorView.onUpdateAmountError("Please insert an amount", 2);
            case 3 -> administratorView.onUpdateAmountError("Please insert a valid amount format", 3);
            case 4 -> administratorView.onUpdateAmountError("Please insert a size", 4);
            case 5 -> administratorView.onUpdateAmountError("Please insert a valid size format", 5);
            default -> // chiama dao per update dei dati
            {
                UpdateDao updateDao = new UpdateDao();
                updateDao.updateAmount(shoe);
                administratorView.onUpdateAmountSuccess();
            }
        }
    }

    @Override
    public void onUpdatePrice(String id, String price) throws SQLException, IOException, ClassNotFoundException {
        Shoe shoe = new Shoe(id, price);

        switch (shoe.isValidPrice()){
            // 0. check for ID is empty
            // 1. check for ID is int
            // 2. check for price is empty
            // 3. check for price is numeric
            case 0 -> administratorView.onUpdatePriceError("Please insert an ID", 0);
            case 1 -> administratorView.onUpdatePriceError("Please insert a valid ID format", 1);
            case 2 -> administratorView.onUpdatePriceError("Please insert a price", 2);
            case 3 -> administratorView.onUpdatePriceError("Please insert a valid price format", 3);
            default ->
            {
                UpdateDao updateDao = new UpdateDao();
                updateDao.updatePrice(shoe);
                administratorView.onUpdatePriceSuccess();
            }
        }
    }

    @Override
    public String getReport() throws SQLException, IOException, ClassNotFoundException {
        ReportDao reportDao = new ReportDao();
        ReportList reportList = reportDao.getReportList();
        return reportList.toStringPrice() + reportList.toStringAmount();
    }
}
