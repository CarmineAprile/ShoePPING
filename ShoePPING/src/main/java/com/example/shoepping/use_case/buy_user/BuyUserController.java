package com.example.shoepping.use_case.buy_user;


import com.example.shoepping.dao.shoe_dao.ShoeDaoJDBC;

import java.io.IOException;
import java.sql.SQLException;

public class BuyUserController implements IBuyUserController{


    @Override
    public String[] onNikeList() throws SQLException, IOException, ClassNotFoundException {
        ShoeDaoJDBC shoeDaoJDBC = new ShoeDaoJDBC();
        return shoeDaoJDBC.getNikePrice();
    }

    @Override
    public String[] onAdidasList() throws SQLException, IOException, ClassNotFoundException {
        ShoeDaoJDBC shoeDaoJDBC = new ShoeDaoJDBC();
        return shoeDaoJDBC.getAdidasPrice();
    }

    @Override
    public String[] onNewBalanceList() throws SQLException, IOException, ClassNotFoundException {
        ShoeDaoJDBC shoeDaoJDBC = new ShoeDaoJDBC();
        return shoeDaoJDBC.getNewBalancePrice();
    }

}
