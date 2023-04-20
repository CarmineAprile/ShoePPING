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

public class BuyUserNikeGController {
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
    Button shoeButton6;
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
    Label model6;
    @FXML
    AnchorPane buyUserNikePane;
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
    @FXML
    Label priceL6;


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
        cw.switchPage(root, buyUserNikePane);
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
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-1(Air-max-97).png", model1.getText(), priceL1.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-2(Air-Jordan-1-Mid).png", model2.getText(), priceL2.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-3(Air-Max-2017).png", model3.getText(), priceL3.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike4() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-4(Nike-Air-Max-90-South-Beach).png", model4.getText(), priceL4.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike5() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-5(Air-Huarache).png", model5.getText(), priceL5.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike6() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-shoe-view.fxml"));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-nike-6(Nike-Air-Max-94).png", model6.getText(), priceL6.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }
}
