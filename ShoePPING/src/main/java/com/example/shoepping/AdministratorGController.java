package com.example.shoepping;

import com.example.shoepping.use_case.administrator.controller.AdministratorController;
import com.example.shoepping.use_case.administrator.controller.IAdministratorController;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;
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


    public void salva() throws SQLException, IOException, ClassNotFoundException {
       IAdministratorController administratorController = new AdministratorController(this);
       catalogTA.setText(administratorController.getReport());
       //passaggio tramite bean, no return -> fare metodo nella view che stampa nella TA
    }

    public void addAmount() throws SQLException, IOException, ClassNotFoundException {
        String idAmount = id1TA.getText();
        String amount = amountTA.getText();
        String size = sizeTA.getText();

        //Serve a "svuotare" le label di errore
        amountL.setText("");

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdateAmount(idAmount, amount, size);
    }
    @Override
    public void onUpdateAmountError(String message, int errorCode) {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is int
        // 4. check for size is empty
        // 5. check for size is int
         if(errorCode == 0 || errorCode == 1 || errorCode == 2 || errorCode == 3 || errorCode == 4 || errorCode == 5){
            amountL.setText(message);
        }
    }
    @Override
    public void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException {
        id1TA.setText("");
        amountTA.setText("");
        sizeTA.setText("");
        salva();
    }

    public void updatePrice() throws SQLException, IOException, ClassNotFoundException {
        String idAmount = id2TA.getText();
        String price = priceTA.getText();

        //Serve a "svuotare" le label di errore
        priceL.setText("");

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdatePrice(idAmount, price);
    }
    @Override
    public void onUpdatePriceError(String message, int errorCode) {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for price is empty
        // 3. check for price is numeric

        if(errorCode == 0 || errorCode == 1 || errorCode == 2 || errorCode == 3){
            priceL.setText(message);
        }
    }
    @Override
    public void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException {
        id2TA.setText("");
        priceTA.setText("");
        salva();
    }

    public void manageSales() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("manage-sales-administrator.view.fxml"));
        Parent root = loader.load();

        ManageSalesAdminGController manageSalesAdminGController = loader.getController();
        manageSalesAdminGController.salva();

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
