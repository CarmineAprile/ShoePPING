package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;

public class BuyShoeGController {

    User user;
    boolean isChecked;
    @FXML
    AnchorPane buyShoePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    ImageView shoeImage;
    @FXML
    Label modelLabel;
    @FXML
    Label priceLabel;
    @FXML
    MenuButton sizeMenu;
    @FXML
    MenuItem item37;
    @FXML
    MenuItem item38;
    @FXML
    MenuItem item39;
    @FXML
    MenuItem item40;
    @FXML
    MenuItem item41;
    @FXML
    MenuItem item42;
    @FXML
    MenuItem item43;
    @FXML
    MenuItem item44;
    @FXML
    MenuItem item45;
    @FXML
    MenuItem item46;
    @FXML
    TextField addressTA;
    @FXML
    TextField cardIDTA;
    @FXML
    Label cardIDL;
    @FXML
    TextField cardDateTA;
    @FXML
    TextField cardCVCTA;
    @FXML
    Label cardDateCVVLabel;
    @FXML
    Button confirmButton;

    public void salva(User user, boolean isChecked, String shoe, String model, String price){
        this.user = user;
        this.isChecked = isChecked;

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(shoe)));
        shoeImage.setImage(image);

        modelLabel.setText(model);

        priceLabel.setText(price);
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyShoePane);
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
        cw.switchPage(root, buyShoePane);
    }

    public void confirm() {
    }
}
