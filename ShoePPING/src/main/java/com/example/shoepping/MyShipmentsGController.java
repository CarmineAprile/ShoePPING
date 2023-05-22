package com.example.shoepping;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyShipmentsGController {
    @FXML
    AnchorPane myShipmentsPane;
    @FXML
    ImageView backButton;
    @FXML
    TextArea shipmentsTA;

    public void salva(String shipments) {
        shipmentsTA.setText(shipments);
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, myShipmentsPane);
    }


}
