package com.example.shoepping.use_case.buy_catalog.controller;

import com.example.shoepping.dao.catalog_dao.CatalogDao;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;
import com.example.shoepping.pattern.filter.*;
import com.example.shoepping.use_case.buy_catalog.view.IBuyCatalogView;

import java.io.IOException;
import java.sql.SQLException;

public class BuyCatalogController implements IBuyCatalogController {

    IBuyCatalogView buyUserUsedShoeView;

    Catalog catalog;

    public BuyCatalogController(IBuyCatalogView buyUserUsedShoeView){
        this.buyUserUsedShoeView = buyUserUsedShoeView;
    }
    @Override
    public void getCatalog() throws SQLException, IOException, ClassNotFoundException {

        CatalogDao catalogDao = new CatalogDao();

        Catalog catalogShoe = catalogDao.getCatalog();

        for(CatalogItem catalogItem : catalogShoe.getCatalog()){
            buyUserUsedShoeView.setShoeLabel(catalogItem.toString());
        }
    }

    @Override
    public void setFilter(String item, String brand, String size, String condition, String price) throws SQLException, IOException, ClassNotFoundException, ManageException {


        if(!price.isEmpty()){
            try{
                Integer.parseInt(price);
            }catch(Exception e){
                try{
                    Double.parseDouble(price);
                }catch(Exception exception){
                    buyUserUsedShoeView.onApplyFilterError();
                }
            }
        }

        CatalogDao catalogDao = new CatalogDao();

        catalog = catalogDao.getCatalog();


        if(!item.isEmpty()){
            Criteria criteriaFind = new CriteriaFind();
            catalog = criteriaFind.meetCriteria(catalog, item);
        }

        if(!brand.equals("Select brand")){
            Criteria criteriaBrand = new CriteriaBrand();
            catalog = criteriaBrand.meetCriteria(catalog, brand);
        }
        if(!size.equals("Select size")){
            Criteria criteriaSize = new CriteriaSize();
            catalog = criteriaSize.meetCriteria(catalog, size);
        }
        if(!condition.equals("Select condition")){
            Criteria criteriaCondition = new CriteriaCondition();
            catalog = criteriaCondition.meetCriteria(catalog, condition);
        }
        if(!price.isEmpty()){
            Criteria criteriaPrice = new CriteriaPrice();
            catalog = criteriaPrice.meetCriteria(catalog, price);
        }

        for(CatalogItem catalogItem : catalog.getCatalog()){
            buyUserUsedShoeView.setShoeLabel(catalogItem.toString());
        }
    }
}
