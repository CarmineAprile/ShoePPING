package com.example.shoepping;

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

    }
    @Override
    public void onUpdateAmountError() {

    }
    @Override
    public void onUpdateAmountSuccess() {

    }

    public void updatePrice() {
        System.out.println("Update price");
    }
    @Override
    public void onUpdatePriceError() {

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
