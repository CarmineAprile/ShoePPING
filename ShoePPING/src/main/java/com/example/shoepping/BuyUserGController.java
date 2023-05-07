package com.example.shoepping;

import com.example.shoepping.use_case.buy_user.BuyUserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;

public class BuyUserGController{

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

    public void onNikeClick() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-nike-view.fxml"));
        Parent root = loader.load();

        BuyUserController buyUserController = new BuyUserController();
        String[] lista = buyUserController.onNikeList();

        BuyUserNikeGController buyUserNikeGController = loader.getController();
        buyUserNikeGController.salva(lista);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }


    public void onAdidasClick() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-adidas-view.fxml"));
        Parent root = loader.load();

        BuyUserController buyUserController = new BuyUserController();
        String[] lista = buyUserController.onAdidasList();

        BuyUserAdidasGController buyUserAdidasGController = loader.getController();
        buyUserAdidasGController.salva(lista);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }


    public void onNewBalanceClick() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-new-balance-view.fxml"));
        Parent root = loader.load();

        BuyUserController buyUserController = new BuyUserController();
        String[] lista = buyUserController.onNewBalanceList();

        BuyUserNewBalanceGController buyUserNewBalanceGController = loader.getController();
        buyUserNewBalanceGController.salva(lista);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }

    public void onSellClick() {
        System.out.println("sell");
    }

    public void onCatalogClick() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-used-shoe-view.fxml"));
        Parent root = loader.load();

        BuyUserUsedShoeGController buyUserUsedShoeGController = loader.getController();
        buyUserUsedShoeGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserPane);
    }
}
