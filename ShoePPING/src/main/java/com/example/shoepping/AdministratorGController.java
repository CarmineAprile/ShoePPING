package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdministratorGController {
    @FXML
    AnchorPane administratorPane;
    @FXML
    TextField id1TA;
    @FXML
    TextField amountTA;
    @FXML
    Button updateButton1;
    @FXML
    Label amountL;
    @FXML
    TextField idTA2;
    @FXML
    TextField priceTA;
    @FXML
    Button updateButton2;
    @FXML
    Label priceL;
    @FXML
    Button manageSalesButton;
    @FXML
    TextArea catalogTA;

    public void updateAmount() {
        System.out.println("Update amount");
    }

    public void updatePrice() {
        System.out.println("Update price");
    }

    public void manageSales() {
        System.out.println("Manage sales");
    }
}
