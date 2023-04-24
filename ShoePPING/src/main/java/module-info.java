module com.example.shoepping {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.opencsv;
    requires jdk.internal.le;


    opens com.example.shoepping to javafx.fxml;
    exports com.example.shoepping;
}