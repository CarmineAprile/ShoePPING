package com.example.shoepping;

import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeButton;
import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
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

import static jdk.internal.org.jline.utils.Log.error;

public class BuyShoeGController implements IBuyShoeView {

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

    public void salva(User user, boolean isChecked, String shoe, String model, String price, ShoeSizeList shoeSizeList){
        this.user = user;
        this.isChecked = isChecked;

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(shoe)));
        shoeImage.setImage(image);

        modelLabel.setText(model);

        priceLabel.setText(price);

        ShoeSizeButton observer37 = new ShoeSizeButton();
        ShoeSizeButton observer38 = new ShoeSizeButton();
        ShoeSizeButton observer39 = new ShoeSizeButton();
        ShoeSizeButton observer40 = new ShoeSizeButton();
        ShoeSizeButton observer41 = new ShoeSizeButton();
        ShoeSizeButton observer42 = new ShoeSizeButton();
        ShoeSizeButton observer43 = new ShoeSizeButton();
        ShoeSizeButton observer44 = new ShoeSizeButton();
        ShoeSizeButton observer45 = new ShoeSizeButton();
        ShoeSizeButton observer46 = new ShoeSizeButton();

        shoeSizeList.addObserver(observer37);
        shoeSizeList.addObserver(observer38);
        shoeSizeList.addObserver(observer39);
        shoeSizeList.addObserver(observer40);
        shoeSizeList.addObserver(observer41);
        shoeSizeList.addObserver(observer42);
        shoeSizeList.addObserver(observer43);
        shoeSizeList.addObserver(observer44);
        shoeSizeList.addObserver(observer45);
        shoeSizeList.addObserver(observer46);

        shoeSizeList.setAvailable();

        IBuyShoeController buyShoeController = new BuyShoeController(this);
        buyShoeController.onUpdate(shoeSizeList);

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
        // da fare
    }

    public void size37(){
        sizeMenu.setText("37");
    }
    public void size38(){
        sizeMenu.setText("38");
    }
    public void size39(){
        sizeMenu.setText("39");
    }
    public void size40(){
        sizeMenu.setText("40");
    }
    public void size41(){
        sizeMenu.setText("41");
    }
    public void size42(){
        sizeMenu.setText("42");
    }
    public void size43(){
        sizeMenu.setText("43");
    }
    public void size44(){
        sizeMenu.setText("44");
    }
    public void size45(){
        sizeMenu.setText("45");
    }
    public void size46(){
        sizeMenu.setText("46");
    }

    @Override
    public void onDisable(int i) {
        switch (i){
            case 37 -> item37.setDisable(true);
            case 38 -> item38.setDisable(true);
            case 39 -> item39.setDisable(true);
            case 40 -> item40.setDisable(true);
            case 41 -> item41.setDisable(true);
            case 42 -> item42.setDisable(true);
            case 43 -> item43.setDisable(true);
            case 44 -> item44.setDisable(true);
            case 45 -> item45.setDisable(true);
            case 46 -> item46.setDisable(true);
            default -> error();

        }
    }
}
