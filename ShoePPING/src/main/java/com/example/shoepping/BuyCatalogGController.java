package com.example.shoepping;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_catalog.controller.BuyCatalogController;
import com.example.shoepping.use_case.buy_catalog.controller.IBuyCatalogController;
import com.example.shoepping.use_case.buy_catalog.view.IBuyCatalogView;
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

public class BuyCatalogGController implements IBuyCatalogView {

    @FXML
    AnchorPane buyCatalogPane;
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
    MenuButton conditionMenu;
    @FXML
    MenuItem itemConditionAsNew;
    @FXML
    MenuItem itemConditionLightlyUsed;
    @FXML
    MenuItem itemConditionAveragelyUsed;
    @FXML
    TextField priceFilter;
    @FXML
    Label maxPriceL;
    @FXML
    Button applyFilter;
    @FXML
    Button resetFilter;
    @FXML
    VBox vBoxCatalog;


    public void start() throws SQLException, IOException, ClassNotFoundException {
        IBuyCatalogController buyUserUsedShoeController = new BuyCatalogController(this);
        buyUserUsedShoeController.getCatalog();
    }

    @Override
    public void setShoeLabel(ModelShoeBean item) {
        Label label = new Label(item.getModelShoe());
        label.setFont(new Font("System Bold", 14));
        label.setPadding(new Insets(0, 0, 10, 0));
        vBoxCatalog.getChildren().add(label);

        // va gestito il passaggio alla pagina successiva della scarpa cliccata
        label.setOnMouseClicked(evt -> {
            try {
                switchPage(label);
            } catch (IOException | SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void switchPage(Label label) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-used-shoe-view.fxml"));
        Parent root = loader.load();

        BuyUserUsedShoeGController buyUserUsedShoeGController = loader.getController();
        buyUserUsedShoeGController.start(label.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyCatalogPane);
    }

    @Override
    public void onApplyFilterError() {
        maxPriceL.setText("Please insert a valid price");
    }

    public void apply() throws SQLException, IOException, ClassNotFoundException, ManageException {
        BuyCatalogController buyCatalogController = new BuyCatalogController(this);

        vBoxCatalog.getChildren().clear();
        maxPriceL.setText("");

        String item = itemFilter.getText();
        String brand = brandMenu.getText();
        String size = sizeMenu.getText();
        String condition = conditionMenu.getText();
        String price = priceFilter.getText();

        ModelShoeBean modelShoeBean = new ModelShoeBean();
        BrandBean brandBean = new BrandBean();
        SizeShoeBean sizeShoeBean = new SizeShoeBean();
        ConditionBean conditionBean = new ConditionBean();
        PriceBean priceBean = new PriceBean();

        modelShoeBean.setModelShoe(item);
        brandBean.setBrand(brand);
        sizeShoeBean.setSizeShoe(size);
        conditionBean.setCondition(condition);
        priceBean.setPrice(price);

        buyCatalogController.setFilter(modelShoeBean, brandBean, sizeShoeBean, conditionBean, priceBean);
    }

    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyCatalogPane);
    }
    public void onSellClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyCatalogPane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, buyCatalogPane);
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

    public void menuBrandNike(){
        brandMenu.setText("Nike");
    }
    public void menuBrandAdidas(){
        brandMenu.setText("Adidas");
    }
    public void menuBrandNewBalance(){
        brandMenu.setText("New Balance");
    }

    public void reset() throws SQLException, IOException, ClassNotFoundException {
        itemFilter.clear();
        brandMenu.setText("Select brand");
        sizeMenu.setText("Select size");
        conditionMenu.setText("Select condition");
        priceFilter.clear();
        vBoxCatalog.getChildren().clear();
        start();
    }

    public void menuConditionAsNew() {
        conditionMenu.setText("As new");
    }
    public void menuConditionLightlyUsed() {
        conditionMenu.setText("Lightly used");
    }
    public void menuConditionAveragelyUsed() {
        conditionMenu.setText("Averagely used");
    }
}
