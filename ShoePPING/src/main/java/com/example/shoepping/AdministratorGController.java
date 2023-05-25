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

import static jdk.internal.org.jline.utils.Log.error;

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
    Button addButton;
    @FXML
    Label amountL;
    @FXML
    TextField idTA2;
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


    public void salva(){
        // fare la select per settare il testo della text area
    }

    public void addAmount() {
        String idAmount = id1TA.getText();
        String amount = amountTA.getText();

        //Serve a "svuotare" le label di errore
        amountL.setText("");

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdateAmount(idAmount, amount);
    }
    @Override
    public void onUpdateAmountError(String message, int errorCode) {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is int
        switch (errorCode){
            case 0, 1, 2, 3 -> amountL.setText(message);
            default -> error();
        }
    }
    @Override
    public void onUpdateAmountSuccess() {

    }

    public void updatePrice() {
        String idAmount = idTA2.getText();
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
        // 4. check for price is empty
        // 5. check for price is numeric
        switch (errorCode){
            case 0, 1, 4, 5 -> priceL.setText(message);
            default -> error();
        }
    }
    @Override
    public void onUpdatePriceSuccess() {

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
