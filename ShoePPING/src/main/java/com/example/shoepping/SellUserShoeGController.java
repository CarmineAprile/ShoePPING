package com.example.shoepping;

import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.pattern.adapter.Adapter;
import com.example.shoepping.use_case.sell_user_shoe.controller.ISellUserShoeController;
import com.example.shoepping.use_case.sell_user_shoe.controller.SellUserShoeController;
import com.example.shoepping.use_case.sell_user_shoe.view.ISellUserShoeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import static jdk.internal.org.jline.utils.Log.error;

import java.io.IOException;

public class SellUserShoeGController implements ISellUserShoeView {
    @FXML
    AnchorPane sellUserShoePane;
    @FXML
    HBox buyButton;
    @FXML
    ImageView userIcon;
    @FXML
    TextField brandTA;
    @FXML
    Label brandL;
    @FXML
    TextField itemTA;
    @FXML
    Label itemL;
    @FXML
    TextField priceTA;
    @FXML
    MenuButton conditionMenu;
    @FXML
    MenuItem asNewOption;
    @FXML
    MenuItem lightlyUsedOption;
    @FXML
    MenuItem averagelyUsed;
    @FXML
    Button reccomendedPriceButton;
    @FXML
    Label priceL;
    @FXML
    ImageView infoButton;
    @FXML
    TextField sizeTA;
    @FXML
    Label sizeL;
    @FXML
    Button insertSale;
    @FXML
    Button manageSales;

    public void insertSale(){
        String brand = brandTA.getText();
        String item = itemTA.getText();
        String price = priceTA.getText();
        String condition = conditionMenu.getText();
        String size = sizeTA.getText();


        //Serve a "svuotare" le label di errore
        brandL.setText("");
        itemL.setText("");
        priceL.setText("");
        sizeL.setText("");

        ISellUserShoeController sellUserShoeController = new SellUserShoeController(this);
        sellUserShoeController.onInsertSale(brand, item, price, condition, size);
    }

    @Override
    public void onInsertSaleError(String message, int code) {

        // 0. Check for brand is Empty
        // 1. Check for item is Empty
        // 2. Check for price is empty
        // 3. Check for price is numeric
        // 4. Check for condition is empty
        // 5. Check for size is empty
        // 6. Check for size is integer

        switch (code){
            case 0 ->brandL.setText(message);
            case 1 ->itemL.setText(message);
            case 2, 3, 4 ->priceL.setText(message);
            case 5, 6, 7 ->sizeL.setText(message);
            default -> error();
        }
    }

    @Override
    public void onIsertSaleSuccess() {
        System.out.println("Messi parte lo steeeeSSSSSOOOOO!!!!");
    }


    public void applyReccomendedPrice(){
        String price = priceTA.getText();
        String condition = conditionMenu.getText();

        ISellUserShoeController sellUserShoeController = new SellUserShoeController(this);
        sellUserShoeController.onReccomendedPriceCalculate(price, condition);
    }
    @Override
    public void onReccomendedPriceCalculateError(String message, int code) {
        switch (code){
            case 0, 1, 2 -> priceL.setText(message);
            default -> error();
        }
    }
    @Override
    public void onReccomendedPriceCalculateSuccess(Sale sale) {
        Adapter adapter = new Adapter();
        String reccomendedPrice = String.valueOf(adapter.calculatePrice(sale.getCondition(), sale.getPrice()));
        priceTA.setText(reccomendedPrice);
    }

    public void onPriceInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info about reccomended price");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("How to use reccomended price:\n\t1) Insert the retail price.\n\t2) Select condition\n\t3) Push the button\n\t4) The reccomended price will be calculated depending on\n\tthe condition of the shoe\n\nOr insert the price you want!");

        alert.showAndWait();
    }

    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, sellUserShoePane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, sellUserShoePane);
    }

    public void asNew() {
        conditionMenu.setText("As new");
    }

    public void lightlyUsed() {
        conditionMenu.setText("Lightly used");
    }

    public void averagelyUsed() {
        conditionMenu.setText("Averagely used");
    }

    public void manageSales() {
        System.out.println("Manage your Sales");
    }

    public void maxLenghtBrand() {
        final int maxLengthBrand = 20;

        if (brandTA.getText().length() > maxLengthBrand) {
            int pos = brandTA.getCaretPosition();
            brandTA.setText(brandTA.getText(0, maxLengthBrand));
            brandTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtItem() {
        final int maxLengthItem = 40;

        if (itemTA.getText().length() > maxLengthItem) {
            int pos = itemTA.getCaretPosition();
            itemTA.setText(itemTA.getText(0, maxLengthItem));
            itemTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtPrice() {
        final int maxLengthPrice = 6;

        if (priceTA.getText().length() > maxLengthPrice) {
            int pos = priceTA.getCaretPosition();
            priceTA.setText(priceTA.getText(0, maxLengthPrice));
            priceTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtSize() {
        final int maxLengthSize = 2;

        if (sizeTA.getText().length() > maxLengthSize) {
            int pos = sizeTA.getCaretPosition();
            sizeTA.setText(sizeTA.getText(0, maxLengthSize));
            sizeTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }
}