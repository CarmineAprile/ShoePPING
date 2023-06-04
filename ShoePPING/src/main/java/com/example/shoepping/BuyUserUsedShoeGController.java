package com.example.shoepping;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_user_used_shoe.controller.BuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.controller.IBuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.view.IBuyUserUsedShoeView;
import com.opencsv.exceptions.CsvValidationException;
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



    public void start(String label) throws SQLException, IOException, ClassNotFoundException {
        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);

        LabelBean labelBean = new LabelBean();
        labelBean.setLabel(label);
        sellIDUpdate = buyUserUsedShoeController.setLabels(labelBean);
    }

    @Override
    public void onLabelsUpdate(IdBean shoeSale, BrandBean shoeBrand, ModelShoeBean shoeItem, PriceBean shoePrice, SizeShoeBean shoeSize, SellerBean shoeUsername, ConditionBean shoeCondition) {
        modelLabel.setText(shoeItem.getModelShoe());
        brandLabel.setText(shoeBrand.getBrand());
        priceL.setText(String.valueOf(shoePrice.getPrice())+'$');
        sizeL.setText(String.valueOf(shoeSize.getSizeShoe()));
        conditionL.setText(shoeCondition.getCondition());
        sellerL.setText(shoeUsername.getSeller());
    }

    public void goBack() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-catalog-view.fxml"));
        Parent root = loader.load();

        BuyCatalogGController buyCatalogGController = loader.getController();
        buyCatalogGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyUserUsedShoePane);
    }
    public void confirm() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
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

        UserVecBean userVecBean = new UserVecBean();
        userVecBean.setAddressUserVec(address);
        userVecBean.setCardIDUserVec(cardID);
        userVecBean.setCardDateUserVec(cardDate);
        userVecBean.setCardCVCUserVec(cardCVC);
        userVecBean.setConditionUserVec(condition);

        ModelShoeBean modelShoeBean = new ModelShoeBean();
        BrandBean brandBean = new BrandBean();
        PriceBean priceBean = new PriceBean();
        SizeShoeBean sizeShoeBean = new SizeShoeBean();
        SellerBean sellerBean = new SellerBean();
        SellIdUpdateBean sellIdUpdateBean = new SellIdUpdateBean();

        modelShoeBean.setModelShoe(item);
        brandBean.setBrand(brand);
        priceBean.setPrice(price);
        sizeShoeBean.setSizeShoe(size);
        sellerBean.setSeller(seller);
        sellIdUpdateBean.setSellIdUpdate(sellIDUpdate);


        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);
        buyUserUsedShoeController.onConfirm(modelShoeBean, brandBean, priceBean, sizeShoeBean, sellerBean, userVecBean, sellIdUpdateBean);

    }

    @Override
    public void onConfirmError(MessageBean message, CodeBean code) {
        /*
        0 empty address
        1 invalid cardID
        2 invalid expiration cardDate
        3 invalid CVC
         */
        switch (code.getCode()){
            case 0 -> addressUsedL.setText(message.getMessage());
            case 1 -> cardIDUsedL.setText(message.getMessage());
            case 2, 3 -> cardDateCVVUsedLabel.setText(message.getMessage());
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
