package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BuyUserNewBalanceGController {
    User user;
    boolean isChecked;
    @FXML
    AnchorPane buyUserNewBalancePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label newBalanceL1;
    @FXML
    Label newBalanceL2;
    @FXML
    Label newBalanceL3;
    @FXML
    Label newBalanceL4;
    @FXML
    Label newBalanceL5;


    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }
    public void onSellClick() {
        System.out.println("sell");
    }
    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }
}
