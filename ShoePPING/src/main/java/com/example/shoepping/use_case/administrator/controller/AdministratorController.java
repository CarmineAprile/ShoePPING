package com.example.shoepping.use_case.administrator.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.report_dao.ReportDao;
import com.example.shoepping.dao.update_dao.UpdateDao;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.report.ReportList;
import com.example.shoepping.model.shoe.Shoe;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class AdministratorController implements IAdministratorController{

    IAdministratorView administratorView;

    public AdministratorController(IAdministratorView administratorView){
        this.administratorView = administratorView;
    }

    @Override
    public void onUpdateAmount(IdBean id, AmountBean amount, SizeShoeBean size) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        Shoe shoe = new Shoe(id.getId(), size.getSizeShoe(), amount.getAmount());

        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is a positive int
        // 4. check for amount is > 0
        // 5. check for size is empty
        // 6. check for size is int

        if(id.getIsValid() == 0)
            utilityOnUpdateAmount("Please insert an ID", 0);
        else if (id.getIsValid() == 1)
            utilityOnUpdateAmount("Please insert a valid ID format", 1);
        else if (amount.getIsValid() == 2)
            utilityOnUpdateAmount("Please insert an amount", 2);
        else if (amount.getIsValid() == 3)
            utilityOnUpdateAmount("Please insert a valid amount format", 3);
        else if (amount.getIsValid() == 4)
            utilityOnUpdateAmount("Please insert a positive amount", 3);
        else if (size.getIsValid() == 5)
            utilityOnUpdateAmount("Please insert a size", 5);
        else if (size.getIsValid() == 6)
            utilityOnUpdateAmount("Please insert a valid size format", 6);
        else {
                // chiama dao per update dei dati
                UpdateDao updateDao = new UpdateDao();
                updateDao.updateAmount(shoe);
                administratorView.onUpdateAmountSuccess();
            }
    }

    @Override
    public void onUpdatePrice(IdBean id, PriceBean price) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        Shoe shoe = new Shoe(id.getId(), price.getPrice());

        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for price is empty
        // 3. check for price is numeric

        System.out.println(id.getId());
        System.out.println(id.getIsValid());

        System.out.println(price.getPrice());
        System.out.println(price.getIsValid());


        if(id.getIsValid() == 0)
            utilityOnUpdatePrice("Please insert an ID", 0);
        else if (id.getIsValid() == 1)
            utilityOnUpdatePrice("Please insert a valid ID format", 1);
        else if(price.getIsValid() == 2)
            utilityOnUpdatePrice("Please insert a price", 2);
        else if (price.getIsValid() == 3)
            utilityOnUpdatePrice("Please insert a valid price format", 3);
        else {
                UpdateDao updateDao = new UpdateDao();
                updateDao.updatePrice(shoe);
                administratorView.onUpdatePriceSuccess();
            }
    }

    private void utilityOnUpdateAmount(String message, int errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        administratorView.onUpdateAmountError(messageBean, codeBean);
    }

    private void utilityOnUpdatePrice(String message, int errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        administratorView.onUpdatePriceError(messageBean, codeBean);
    }

    @Override
    public String getReport() throws SQLException, IOException, ClassNotFoundException {
        ReportDao reportDao = new ReportDao();
        ReportList reportList = reportDao.getReportList();
        return reportList.toStringPrice() + reportList.toStringAmount();
    }
}
