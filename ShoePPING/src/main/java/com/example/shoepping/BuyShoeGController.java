package com.example.shoepping;



import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import com.opencsv.exceptions.CsvValidationException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyShoeGController implements IBuyShoeView {

    @FXML
    AnchorPane buyShoePane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView backButton;
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
    Label sizeL;
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
    Label addressL;
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
    /* serve per capire in che schermata andare quando viene effettuato il goBack()
    UNO: torna al catalogo delle nike
    DUE: torna al catalogo delle adidas
    TRE: torna al catalogo delle newBalance
    */
    int reference;
    static final String BUY_USER_VIEW_FXML = "buy-user-view.fxml";
    XYChart.Series<String, Integer> barchart;

    public void start(String shoe, String model, String price, int reference) throws SQLException, IOException, ClassNotFoundException {

        this.reference = reference;

        IBuyShoeController buyShoeController = new BuyShoeController(this);

        ModelShoeBean modelShoeBean = new ModelShoeBean();
        modelShoeBean.setModelShoe(model);

        buyShoeController.getSizeAmountList(modelShoeBean);

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(shoe)));
        shoeImage.setImage(image);

        modelLabel.setText(model);

        priceLabel.setText(price);
    }

    public void goBack() throws IOException, SQLException, ClassNotFoundException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(BUY_USER_VIEW_FXML));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage1(root, buyShoePane);

        switch (reference) {
            case 1 -> buyUserGController.onNikeClick();
            case 2 -> buyUserGController.onAdidasClick();
            case 3 -> buyUserGController.onNewBalanceClick();
            default -> error();
        }
    }
    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(BUY_USER_VIEW_FXML));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyShoePane);
    }
    public void onSellClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyShoePane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyShoePane);
    }

    public void confirm() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        String model = modelLabel.getText();
        String price = priceLabel.getText();
        String size = sizeMenu.getText();
        String address = addressTA.getText();
        String cardID = cardIDTA.getText();
        String cardDate = cardDateTA.getText();
        String cardCVC = cardCVCTA.getText();

        //Serve a "svuotare" le label di errore
        sizeL.setText("");
        addressL.setText("");
        cardIDL.setText("");
        cardDateCVVLabel.setText("");

        OrderVecBean orderVecBean = new OrderVecBean();
        orderVecBean.setModelShoeOrderVec(model);
        orderVecBean.setPriceShoeOrderVec(removeLastChar(price));
        orderVecBean.setSizeOrderVec(size);
        orderVecBean.setAddressOrderVec(address);
        orderVecBean.setCardIDOrderVec(cardID);
        orderVecBean.setCardDateOrderVec(cardDate);
        orderVecBean.setCardCVCOrderVec(cardCVC);

        IBuyShoeController buyShoeController = new BuyShoeController(this);
        buyShoeController.onConfirm(orderVecBean);
    }
    @Override
    public void onConfirmSuccess() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(BUY_USER_VIEW_FXML));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyShoePane);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order received successfully");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Order received successfully!");

        alert.showAndWait();
    }

    @Override
    public void onConfirmError(MessageBean message, CodeBean code) {
        /*
        0 not selected size
        1 empty address
        2 invalid cardID
        3 invalid expiration cardDate
        4 invalid CVC
         */
        switch (code.getCode()){
            case 0 -> sizeL.setText(message.getMessage());
            case 1 -> addressL.setText(message.getMessage());
            case 2 -> cardIDL.setText(message.getMessage());
            case 3, 4 -> cardDateCVVLabel.setText(message.getMessage());
            default -> error();
        }
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
    public void onDisable(SizeShoeBean sizeShoeBean) {
        switch (sizeShoeBean.getSizeShoe()){
            case "37" -> item37.setDisable(true);
            case "38" -> item38.setDisable(true);
            case "39" -> item39.setDisable(true);
            case "40" -> item40.setDisable(true);
            case "41" -> item41.setDisable(true);
            case "42" -> item42.setDisable(true);
            case "43" -> item43.setDisable(true);
            case "44" -> item44.setDisable(true);
            case "45" -> item45.setDisable(true);
            case "46" -> item46.setDisable(true);
            default -> error();

        }
    }

    @Override
    public void onBarchart(BarchartBean barchartBean) {
        this.barchart = barchartBean.getBarchart();
    }

    public void maxLengthAddress() {
        final int maxLengthAddress = 40;

        if (addressTA.getText().length() > maxLengthAddress) {
            int pos = addressTA.getCaretPosition();
            addressTA.setText(addressTA.getText(0, maxLengthAddress));
            addressTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLengthCardID() {
        final int maxLengthCardID = 19;

        if (cardIDTA.getText().length() > maxLengthCardID) {
            int pos = cardIDTA.getCaretPosition();
            cardIDTA.setText(cardIDTA.getText(0, maxLengthCardID));
            cardIDTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLengthDate() {
        final int maxLengthDate = 5;

        if (cardDateTA.getText().length() > maxLengthDate) {
            int pos = cardDateTA.getCaretPosition();
            cardDateTA.setText(cardDateTA.getText(0, maxLengthDate));
            cardDateTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLengthCVC() {
        final int maxLengthCVC = 3;

        if (cardCVCTA.getText().length() > maxLengthCVC) {
            int pos = cardCVCTA.getCaretPosition();
            cardCVCTA.setText(cardCVCTA.getText(0, maxLengthCVC));
            cardCVCTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
}
