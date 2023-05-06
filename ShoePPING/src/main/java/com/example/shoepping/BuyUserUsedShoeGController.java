package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;

public class BuyUserUsedShoeGController {

    User user;
    boolean isChecked;
    String[] lista = {"12", "15"};
    @FXML
    AnchorPane buyUserUsedShoePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    TextField itemFilter;
    @FXML
    MenuButton brandMenu;
    @FXML
    MenuButton sizeMenu;
    @FXML
    MenuItem itemSize37;
    @FXML
    MenuItem itemSize38;
    @FXML
    MenuItem itemSize39;
    @FXML
    MenuItem itemSize40;
    @FXML
    MenuItem itemSize41;
    @FXML
    MenuItem itemSize42;
    @FXML
    MenuItem itemSize43;
    @FXML
    MenuItem itemSize44;
    @FXML
    MenuItem itemSize45;
    @FXML
    MenuItem itemSize46;

    @FXML
    TextField priceFilter;
    @FXML
    Label maxPriceL;
    @FXML
    Button applyFilter;
    @FXML
    VBox vBoxCatalog;


    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;

        for(int i = 0; i<2; i++){
            Label label = new Label(lista[i]);
            label.setFont(new Font("System Bold", 12));
            label.setPadding(new Insets(0, 0, 10, 0));
            vBoxCatalog.getChildren().add(label);
            label.setOnMouseClicked(evt -> System.out.println(label.getText()));
        }
    }

    public void apply() {
        System.out.println("Apply filter");
    }

    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
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
        cw.switchPage(root, buyUserUsedShoePane);
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
}
