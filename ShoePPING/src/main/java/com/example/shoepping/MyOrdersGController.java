package com.example.shoepping;

import com.example.shoepping.model.user.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyOrdersGController {
    User user;
    boolean isChecked;
    @FXML
    AnchorPane myOrdersPane;
    @FXML
    ImageView backButton;
    @FXML
    TextArea ordersTA;


    public void salva(User user, boolean isChecked, String orders){
        this.user = user;
        this.isChecked = isChecked;

        ordersTA.setText(orders);
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, myOrdersPane);
    }
}
