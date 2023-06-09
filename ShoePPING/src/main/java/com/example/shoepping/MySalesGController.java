package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MySalesGController {
    @FXML
    AnchorPane mySalesPane;
    @FXML
    ImageView backButton;
    @FXML
    TextArea salesTA;

    public void start(String sales) {
        salesTA.setText(sales);
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.start();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, mySalesPane);
    }


}
