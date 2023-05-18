package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;

public class BuyUserNikeGController {
    static final String SCHERMATA = "buy-user-shoe-view.fxml";
    @FXML
    Button nikeButton1;
    @FXML
    Button nikeButton2;
    @FXML
    Button nikeButton3;
    @FXML
    Button nikeButton4;
    @FXML
    Button nikeButton5;
    @FXML
    Button nikeButton6;
    @FXML
    Label nikeModel1;
    @FXML
    Label nikeModel2;
    @FXML
    Label nikeModel3;
    @FXML
    Label nikeModel4;
    @FXML
    Label nikeModel5;
    @FXML
    Label nikeModel6;
    @FXML
    AnchorPane buyUserNikePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label nikePriceL1;
    @FXML
    Label nikePriceL2;
    @FXML
    Label nikePriceL3;
    @FXML
    Label nikePriceL4;
    @FXML
    Label nikePriceL5;
    @FXML
    Label nikePriceL6;


    public void salva(String[] lista){
        setNikePrice(lista);
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }
    public void onSellClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }
    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void setNikePrice(String[] lista){
        nikePriceL1.setText(lista[0] + '$');
        nikePriceL2.setText(lista[1] + '$');
        nikePriceL3.setText(lista[2] + '$');
        nikePriceL4.setText(lista[3] + '$');
        nikePriceL5.setText(lista[4] + '$');
        nikePriceL6.setText(lista[5] + '$');
    }

    public void onNike1() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-1(Air-max-97).png", nikeModel1.getText(), nikePriceL1.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike2() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-2(Air-Jordan-1-Mid).png", nikeModel2.getText(), nikePriceL2.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike3() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();


        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-3(Air-Max-2017).png", nikeModel3.getText(), nikePriceL3.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike4() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();


        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-4(Nike-Air-Max-90-South-Beach).png", nikeModel4.getText(), nikePriceL4.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike5() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-5(Air-Huarache).png", nikeModel5.getText(), nikePriceL5.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }

    public void onNike6() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva("/drawable/shoe-nike-6(Nike-Air-Max-94).png", nikeModel6.getText(), nikePriceL6.getText(), 1);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserNikePane);
    }
}
