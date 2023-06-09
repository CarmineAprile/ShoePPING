package com.example.shoepping;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



import static com.example.shoepping.SplashGController.image;

public class ChangeWindow {

    private final String title = "ShoePPING";
    public void switchPage(Parent root, AnchorPane pane){
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //lock dimension of window
        stage.setResizable(false);
        stage.setTitle(title);

        //set icon in stage
        stage.getIcons().add(image);
        stage.show();

        pane.getScene().getWindow().hide();
    }

    public void switchPage1(Parent root, AnchorPane pane){
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //lock dimension of window
        stage.setResizable(false);
        stage.setTitle(title);

        //set icon in stage
        stage.getIcons().add(image);

        pane.getScene().getWindow().hide();
    }

    public void openPage(Parent root){
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //lock dimension of window
        stage.setResizable(false);
        stage.setTitle(title);

        //set icon in stage
        stage.getIcons().add(image);
        stage.show();
    }

}
