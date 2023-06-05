package com.example.shoepping;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.administrator.controller.AdministratorController;
import com.example.shoepping.use_case.administrator.controller.IAdministratorController;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;
import com.opencsv.exceptions.CsvValidationException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;

public class AdministratorGController implements IAdministratorView {
    @FXML
    HBox logOutButton;
    @FXML
    AnchorPane administratorPane;
    @FXML
    TextField id1TA;
    @FXML
    TextField amountTA;
    @FXML
    TextField sizeTA;
    @FXML
    Button addButton;
    @FXML
    Label amountL;
    @FXML
    TextField id2TA;
    @FXML
    TextField priceTA;
    @FXML
    Button updateButton;
    @FXML
    Label priceL;
    @FXML
    Button manageSalesButton;
    @FXML
    TextArea catalogTA;


    public void start() throws SQLException, IOException, ClassNotFoundException {
       IAdministratorController administratorController = new AdministratorController(this);
       catalogTA.setText(administratorController.getReport());
    }

    public void addAmount() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        String idAmount = id1TA.getText();
        String amount = amountTA.getText();
        String size = sizeTA.getText();

        //Serve a "svuotare" le label di errore
        amountL.setText("");

        IdBean idBean = new IdBean();
        AmountBean amountBean = new AmountBean();
        SizeShoeBean sizeShoeBean = new SizeShoeBean();

        idBean.setId(idAmount);
        amountBean.setAmount(amount);
        sizeShoeBean.setSizeShoe(size);

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdateAmount(idBean, amountBean, sizeShoeBean);
    }
    @Override
    public void onUpdateAmountError(MessageBean message, CodeBean errorCode) {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is a positive integer
        // 5. check for size is empty
        // 6. check for size is int
         if(errorCode.getCode() == 0 || errorCode.getCode() == 1 || errorCode.getCode() == 2 || errorCode.getCode() == 3 || errorCode.getCode() == 5 || errorCode.getCode() == 6){
            amountL.setText(message.getMessage());
        }
    }
    @Override
    public void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException {
        id1TA.setText("");
        amountTA.setText("");
        sizeTA.setText("");
        start();
    }

    public void updatePrice() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        String idAmount = id2TA.getText();
        String price = priceTA.getText();

        //Serve a "svuotare" le label di errore
        priceL.setText("");

        IdBean idBean = new IdBean();
        PriceBean priceBean = new PriceBean();

        idBean.setId(idAmount);
        priceBean.setPrice(price);

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdatePrice(idBean, priceBean);
    }
    @Override
    public void onUpdatePriceError(MessageBean message, CodeBean errorCode) {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for price is empty
        // 3. check for price is numeric

        if(errorCode.getCode() == 0 || errorCode.getCode() == 1 || errorCode.getCode() == 2 || errorCode.getCode() == 3){
            priceL.setText(message.getMessage());
        }
    }
    @Override
    public void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException {
        id2TA.setText("");
        priceTA.setText("");
        start();
    }

    public void manageSales() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("manage-sales-administrator.view.fxml"));
        Parent root = loader.load();

        ManageSalesAdminGController manageSalesAdminGController = loader.getController();
        manageSalesAdminGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, administratorPane);
    }

    public void onLogOutClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, administratorPane);
    }
}
