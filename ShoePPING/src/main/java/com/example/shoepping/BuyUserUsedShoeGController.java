package com.example.shoepping;

import com.example.shoepping.use_case.buy_user_used_shoe.controller.BuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.controller.IBuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.view.IBuyUserUsedShoeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserUsedShoeGController implements IBuyUserUsedShoeView {

    @FXML
    AnchorPane buyUserUsedShoePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView backButton;
    @FXML
    ImageView userIcon;
    @FXML
    Label modelLabel;
    @FXML
    Label brandLabel;
    @FXML
    Label priceL;
    @FXML
    Label sizeL;
    @FXML
    Label conditionL;
    @FXML
    Label sellerL;
    @FXML
    TextField addressUsedTA;
    @FXML
    Label addressUsedL;
    @FXML
    TextField cardIDUsedTA;
    @FXML
    Label cardIDUsedL;
    @FXML
    TextField cardDateUsedTA;
    @FXML
    TextField cardCVCUsedTA;
    @FXML
    Label cardDateCVVUsedLabel;
    @FXML
    Button confirmUsedButton;

    String sellIDUpdate;



    public void salva(String label) throws SQLException, IOException, ClassNotFoundException {
        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);
        sellIDUpdate = buyUserUsedShoeController.setLabels(label);
    }

    @Override
    public void onLabelsUpdate(int shoeSale, String shoeBrand, String shoeItem, double shoePrice, int shoeSize, String shoeUsername, String shoeCondition) {
        modelLabel.setText(shoeItem);
        brandLabel.setText(shoeBrand);
        priceL.setText(String.valueOf(shoePrice)+'$');
        sizeL.setText(String.valueOf(shoeSize));
        conditionL.setText(shoeCondition);
        sellerL.setText(shoeUsername);
    }

    public void goBack() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-catalog-view.fxml"));
        Parent root = loader.load();

        BuyCatalogGController buyCatalogGController = loader.getController();
        buyCatalogGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }
    public void confirm() throws SQLException, IOException, ClassNotFoundException {
        String item = modelLabel.getText();
        String brand = brandLabel.getText();
        String price = removeLastChar(priceL.getText());
        String size = sizeL.getText();
        String seller = sellerL.getText();
        String condition = conditionL.getText();

        String address = addressUsedTA.getText();
        String cardID = cardIDUsedTA.getText();
        String cardDate = cardDateUsedTA.getText();
        String cardCVC = cardCVCUsedTA.getText();

        addressUsedL.setText("");
        cardIDUsedL.setText("");
        cardDateCVVUsedLabel.setText("");

        String[] userDataVec = {address, cardID, cardDate, cardCVC, condition};

        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);
        buyUserUsedShoeController.onConfirm(item, brand, price, size, seller, userDataVec, sellIDUpdate);

    }

    @Override
    public void onConfirmError(String message, int code) {
        /*
        0 empty address
        1 invalid cardID
        2 invalid expiration cardDate
        3 invalid CVC
         */
        switch (code){
            case 0 -> addressUsedL.setText(message);
            case 1 -> cardIDUsedL.setText(message);
            case 2, 3 -> cardDateCVVUsedLabel.setText(message);
            default -> error();
        }
    }

    @Override
    public void onConfirmSuccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order received successfully");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Order received successfully!");

        alert.showAndWait();
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }

    public void onSellClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }

    public void maxLenghtAddress() {
        final int maxLengthAddress = 40;

        if (addressUsedTA.getText().length() > maxLengthAddress) {
            int pos = addressUsedTA.getCaretPosition();
            addressUsedTA.setText(addressUsedTA.getText(0, maxLengthAddress));
            addressUsedTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtCardID() {
        final int maxLengthCardID = 19;

        if (cardIDUsedTA.getText().length() > maxLengthCardID) {
            int pos = cardIDUsedTA.getCaretPosition();
            cardIDUsedTA.setText(cardIDUsedTA.getText(0, maxLengthCardID));
            cardIDUsedTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtDate() {
        final int maxLengthDate = 5;

        if (cardDateUsedTA.getText().length() > maxLengthDate) {
            int pos = cardDateUsedTA.getCaretPosition();
            cardDateUsedTA.setText(cardDateUsedTA.getText(0, maxLengthDate));
            cardDateUsedTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtCVC() {
        final int maxLengthCVC = 3;

        if (cardCVCUsedTA.getText().length() > maxLengthCVC) {
            int pos = cardCVCUsedTA.getCaretPosition();
            cardCVCUsedTA.setText(cardCVCUsedTA.getText(0, maxLengthCVC));
            cardCVCUsedTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }

}
