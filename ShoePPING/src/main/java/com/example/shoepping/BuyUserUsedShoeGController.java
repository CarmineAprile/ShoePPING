package com.example.shoepping;

import com.example.shoepping.use_case.buy_used_shoe.Controller.BuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_used_shoe.Controller.IBuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_used_shoe.View.IBuyUserUsedShoeView;
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
import java.sql.SQLException;

public class BuyUserUsedShoeGController implements IBuyUserUsedShoeView {
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


    public void salva() throws SQLException, IOException, ClassNotFoundException {
        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);
        buyUserUsedShoeController.getCatalog();
    }

    @Override
    public void setShoeLabel(String item) {
        Label label = new Label(item);
        label.setFont(new Font("System Bold", 14));
        label.setPadding(new Insets(0, 0, 10, 0));
        vBoxCatalog.getChildren().add(label);

        // va gestito il passaggio alla pagina successiva della scarpa cliccata
        label.setOnMouseClicked(evt -> System.out.println(label.getText()));
    }

    public void apply() {
        System.out.println("Apply filter");
    }

    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();



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
        profileGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }

    public void menuSize37(){
        sizeMenu.setText("37");
    }
    public void menuSize38(){
        sizeMenu.setText("38");
    }
    public void menuSize39(){
        sizeMenu.setText("39");
    }
    public void menuSize40(){
        sizeMenu.setText("40");
    }
    public void menuSize41(){
        sizeMenu.setText("41");
    }
    public void menuSize42(){
        sizeMenu.setText("42");
    }
    public void menuSize43(){
        sizeMenu.setText("43");
    }
    public void menuSize44(){
        sizeMenu.setText("44");
    }
    public void menuSize45(){
        sizeMenu.setText("45");
    }
    public void menuSize46(){
        sizeMenu.setText("46");
    }
}
