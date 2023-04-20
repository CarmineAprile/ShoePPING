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
    @FXML
    Button shoeButton1;
    @FXML
    Button shoeButton2;
    @FXML
    Button shoeButton3;
    @FXML
    Button shoeButton4;
    @FXML
    Button shoeButton5;
    @FXML
    Label model1;
    @FXML
    Label model2;
    @FXML
    Label model3;
    @FXML
    Label model4;
    @FXML
    Label model5;
    @FXML
    AnchorPane buyUserNewBalancePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label priceL1;
    @FXML
    Label priceL2;
    @FXML
    Label priceL3;
    @FXML
    Label priceL4;
    @FXML
    Label priceL5;


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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-1(327-Moonbeam).png", model1.getText(), priceL1.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-2(X-Racer-Bodega).png", model2.getText(), priceL2.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-3(Shando).png", model3.getText(), priceL3.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance4() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-4(530).png", model4.getText(), priceL4.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }

    public void onNewBalance5() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-new-balance-5(550-White-Red).png", model5.getText(), priceL5.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNewBalancePane);
    }
}
