package com.example.shoepping.use_case.buy_used_shoe.Controller;

import com.example.shoepping.dao.catalog_dao.CatalogDao;
import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;
import com.example.shoepping.use_case.buy_used_shoe.View.IBuyUserUsedShoeView;

import java.io.IOException;
import java.sql.SQLException;

public class BuyUserUsedShoeController implements IBuyUserUsedShoeController{

    IBuyUserUsedShoeView buyUserUsedShoeView;

    public BuyUserUsedShoeController(IBuyUserUsedShoeView buyUserUsedShoeView){
        this.buyUserUsedShoeView = buyUserUsedShoeView;
    }
    @Override
    public void getCatalog() throws SQLException, IOException, ClassNotFoundException {
        Catalog catalog;
        CatalogDao catalogDao = new CatalogDao();

        catalog = catalogDao.getCatalog();

        for(CatalogItem catalogItem : catalog.getCatalog()){
            buyUserUsedShoeView.setShoeLabel(catalogItem.toString());
        }
    }
}
