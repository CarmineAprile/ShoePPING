package com.example.shoepping;

import com.example.shoepping.use_case.manage_sale.controller.IManageSaleController;
import com.example.shoepping.use_case.manage_sale.controller.ManageSaleController;
import com.example.shoepping.use_case.manage_sale.view.IManageSaleView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManageSaleGController implements IManageSaleView {
    @FXML
    AnchorPane manageSaleCatalogPane;
    @FXML
    HBox buyButton;
    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    ImageView backButton;
    @FXML
    VBox vBoxSales;

    String format = "System Bold";

    public void salva() throws SQLException, IOException, ClassNotFoundException {
        IManageSaleController manageSaleController = new ManageSaleController(this);
        manageSaleController.getSales();
    }

    @Override
    public void setNotAvailableCSV() {
        Label label = new Label("Not available yet!");
        vBoxSales.getChildren().add(label);
    }

    @Override
    public void setSaleButton(String sale, List<String> itemData) {
        HBox hBox = new HBox();
        hBox.setPrefWidth(638);
        hBox.setPadding(new Insets(10, 0, 0,0));

        Label label = new Label(sale);
        label.setPrefWidth(450);
        label.setFont(new Font(format, 12));
        label.setPadding(new Insets(5, 30, 5, 5));

        Button buttonConfirm = new Button("Confirm");
        buttonConfirm.setFont(new Font(format, 12));
        buttonConfirm.setPadding(new Insets(5,10,5,10));
        buttonConfirm.setTextFill(Paint.valueOf("green"));
        buttonConfirm.setFocusTraversable(false);

        Label filler = new Label("    ");
        filler.setPadding(new Insets(5, 30, 5, 0));

        Button buttonRefuse = new Button("Refused");
        buttonRefuse.setFont(new Font(format, 12));
        buttonRefuse.setPadding(new Insets(5,10,5,10));
        buttonRefuse.setTextFill(Paint.valueOf("red"));
        buttonRefuse.setFocusTraversable(false);

        hBox.getChildren().add(label);
        hBox.getChildren().add(buttonConfirm);
        hBox.getChildren().add(filler);
        hBox.getChildren().add(buttonRefuse);
        vBoxSales.getChildren().add(hBox);

        IManageSaleController manageSaleController = new ManageSaleController(this);

        buttonConfirm.setOnAction(evt -> {
            hBox.getChildren().remove(buttonConfirm);
            hBox.getChildren().remove(buttonRefuse);
            filler.setText("Sale confirmed");

            try {
                manageSaleController.onConfirmSale(itemData);
            } catch (SQLException | IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        buttonRefuse.setOnAction(evt -> {
            hBox.getChildren().remove(buttonConfirm);
            hBox.getChildren().remove(buttonRefuse);
            filler.setText("Sale refused");

            try {
                manageSaleController.onRefuseSale(itemData);
            } catch (SQLException | IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void onBuyClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, manageSaleCatalogPane);
    }

    public void onSellClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, manageSaleCatalogPane);
    }

    public void onProfileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, manageSaleCatalogPane);
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, manageSaleCatalogPane);
    }
}
