package com.example.shoepping.use_case.buy_catalog.controller;

import com.example.shoepping.bean.*;
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
            ModelShoeBean modelShoeBean = new ModelShoeBean();
            modelShoeBean.setModelShoe(catalogItem.toString());
            buyUserUsedShoeView.setShoeLabel(modelShoeBean);
        }
    }

    @Override
    public void setFilter(ModelShoeBean item, BrandBean brand, SizeShoeBean size, ConditionBean condition, PriceBean price) throws SQLException, IOException, ClassNotFoundException, ManageException {


        if(!price.getPrice().isEmpty()){
            try{
                Integer.parseInt(price.getPrice());
            }catch(Exception e){
                try{
                    Double.parseDouble(price.getPrice());
                }catch(Exception exception){
                    buyUserUsedShoeView.onApplyFilterError();
                    return;
                }
            }
        }

        CatalogDao catalogDao = new CatalogDao();

        catalog = catalogDao.getCatalog();


        if(!item.getModelShoe().isEmpty()){
            Criteria criteriaFind = new CriteriaFind();
            catalog = criteriaFind.meetCriteria(catalog, item.getModelShoe());
        }

        if(!brand.getBrand().equals("Select brand")){
            Criteria criteriaBrand = new CriteriaBrand();
            catalog = criteriaBrand.meetCriteria(catalog, brand.getBrand());
        }
        if(!size.getSizeShoe().equals("Select size")){
            Criteria criteriaSize = new CriteriaSize();
            catalog = criteriaSize.meetCriteria(catalog, size.getSizeShoe());
        }
        if(!condition.getCondition().equals("Select condition")){
            Criteria criteriaCondition = new CriteriaCondition();
            catalog = criteriaCondition.meetCriteria(catalog, condition.getCondition());
        }
        if(!price.getPrice().isEmpty()){
            Criteria criteriaPrice = new CriteriaPrice();
            catalog = criteriaPrice.meetCriteria(catalog, price.getPrice());
        }

        for(CatalogItem catalogItem : catalog.getCatalog()){
            ModelShoeBean modelShoeBean = new ModelShoeBean();
            modelShoeBean.setModelShoe(catalogItem.toString());
            buyUserUsedShoeView.setShoeLabel(modelShoeBean);
        }
    }
}
