package com.example.shoepping;

import com.example.shoepping.model.User;
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
    AnchorPane MyOrdersPane;
    @FXML
    ImageView backButton;
    @FXML
    TextArea ordersTA;


    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController = loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, MyOrdersPane);
    }

    public void setText(String numero, String date, String item, String price, String status){
        // va aggiustato
        ordersTA.setText("Number: " + numero +"\n\nDate: " + date +"\n\nItem: " + item +"\n\nPrice: " + price +"\n\nStatus: " + status);
    }
}
