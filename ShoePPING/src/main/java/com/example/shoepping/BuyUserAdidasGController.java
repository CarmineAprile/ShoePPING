package com.example.shoepping;

import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.use_case.buy_brands.BuyUserBrandsController;
import com.example.shoepping.use_case.buy_brands.IBuyUserBrandsController;
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


public class BuyUserAdidasGController {
    User user;
    boolean isChecked;

    static final String SCHERMATA = "buy-user-shoe-view.fxml";
    @FXML
    Button adidasButton1;
    @FXML
    Button adidasButton2;
    @FXML
    Button adidasButton3;
    @FXML
    Button adidasButton4;
    @FXML
    Button adidasButton5;

    @FXML
    Label adidasModel1;
    @FXML
    Label adidasModel2;
    @FXML
    Label adidasModel3;
    @FXML
    Label adidasModel4;
    @FXML
    Label adidasModel5;
    @FXML
    AnchorPane buyUserAdidasPane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label adidasPriceL1;
    @FXML
    Label adidasPriceL2;
    @FXML
    Label adidasPriceL3;
    @FXML
    Label adidasPriceL4;
    @FXML
    Label adidasPriceL5;


    public void salva(User user, boolean isChecked, String[] lista){
        this.user = user;
        this.isChecked = isChecked;
        setAdidasPrice(lista);
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
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
        cw.switchPage(root, buyUserAdidasPane);
    }

    public void setAdidasPrice(String[] lista){
        adidasPriceL1.setText(lista[0] + '$');
        adidasPriceL2.setText(lista[1] + '$');
        adidasPriceL3.setText(lista[2] + '$');
        adidasPriceL4.setText(lista[3] + '$');
        adidasPriceL5.setText(lista[4] + '$');
    }

    public void onAdidas1() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        IBuyUserBrandsController buyUserAdidasController = new BuyUserBrandsController();
        ShoeSizeList shoeSizeList = buyUserAdidasController.getSizeAmountList(adidasModel1.getText());

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-adidas-1(Gazelle).png", adidasModel1.getText(), adidasPriceL1.getText(), shoeSizeList);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
    }

    public void onAdidas2() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        IBuyUserBrandsController buyUserAdidasController = new BuyUserBrandsController();
        ShoeSizeList shoeSizeList = buyUserAdidasController.getSizeAmountList(adidasModel2.getText());

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-adidas-2(Stan-Smith).png", adidasModel2.getText(), adidasPriceL2.getText(), shoeSizeList);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
    }

    public void onAdidas3() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        IBuyUserBrandsController buyUserAdidasController = new BuyUserBrandsController();
        ShoeSizeList shoeSizeList = buyUserAdidasController.getSizeAmountList(adidasModel3.getText());

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-adidas-3(Yeezy-Boost-350).png", adidasModel3.getText(), adidasPriceL3.getText(), shoeSizeList);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
    }

    public void onAdidas4() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        IBuyUserBrandsController buyUserAdidasController = new BuyUserBrandsController();
        ShoeSizeList shoeSizeList = buyUserAdidasController.getSizeAmountList(adidasModel4.getText());

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-adidas-4(EQT-Flurro-Yellow).png", adidasModel4.getText(), adidasPriceL4.getText(), shoeSizeList);
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
    }

    public void onAdidas5() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SCHERMATA));
        Parent root = loader.load();

        IBuyUserBrandsController buyUserAdidasController = new BuyUserBrandsController();
        ShoeSizeList shoeSizeList = buyUserAdidasController.getSizeAmountList(adidasModel5.getText());

        BuyShoeGController buyShoeGController= loader.getController();
        buyShoeGController.salva(user, isChecked, "/drawable/shoe-adidas-5(Superstar).png", adidasModel5.getText(), adidasPriceL5.getText(), shoeSizeList);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserAdidasPane);
    }
}
