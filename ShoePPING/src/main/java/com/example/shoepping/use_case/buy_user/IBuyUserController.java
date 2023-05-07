package com.example.shoepping.use_case.buy_user;


import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserController {

    String[] onNikeList() throws SQLException, IOException, ClassNotFoundException;
    String[] onAdidasList() throws SQLException, IOException, ClassNotFoundException;
    String[] onNewBalanceList() throws SQLException, IOException, ClassNotFoundException;
}