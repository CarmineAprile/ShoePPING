package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BuyUserNewBalanceGController {
    User user;
    boolean isChecked;

    static final String schermata = "buy-user-shoe-view.fxml";
    @FXML
    Button newBalanceButton1;
    @FXML
    Button newBalanceButton2;
    @FXML
    Button newBalanceButton3;
    @FXML
    Button newBalanceButton4;
    @FXML
    Button newBalanceButton5;
    @FXML
    Label newBalancemodel1;
    @FXML
    Label newBalancemodel2;
    @FXML
    Label newBalancemodel3;
    @FXML
    Label newBalancemodel4;
    @FXML
    Label newBalancemodel5;
    @FXML
    AnchorPane buyUserNewBalancePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label newBalancepriceL1;
    @FXML
    Label newBalancepriceL2;
    @FXML
    Label newBalancepriceL3;
    @FXML
    Label newBalancepriceL4;
    @FXML
    Label newBalancepriceL5;


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

    public void onNewBalance1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(schermata));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-1(327-Moonbeam).png", newBalancemodel1.getText(), newBalancepriceL1.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(schermata));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-2(X-Racer-Bodega).png", newBalancemodel2.getText(), newBalancepriceL2.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(schermata));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-3(Shando).png", newBalancemodel3.getText(), newBalancepriceL3.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance4() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(schermata));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-4(530).png", newBalancemodel4.getText(), newBalancepriceL4.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance5() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(schermata));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-5(550-White-Red).png", newBalancemodel5.getText(), newBalancepriceL5.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }
}
