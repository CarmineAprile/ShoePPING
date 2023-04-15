package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BuyUserGController{

    User user;
    boolean isChecked;
    @FXML
    AnchorPane buyUserPane;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Button nikeButton;
    @FXML
    Button adidasButton;
    @FXML
    Button newBalanceButton;
    @FXML
    Button catalogButton;

    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;
    }


    public void onNike() {
        System.out.println("nike");
    }


    public void onAdidasClick() {
        System.out.println("adidas");
    }


    public void onNewBalanceClick() {
        System.out.println("newbalance");
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }

    public void onSellClick() {
        System.out.println("sell");
    }

    public void onCatalogClick() {
        System.out.println("catalog");
    }
}
