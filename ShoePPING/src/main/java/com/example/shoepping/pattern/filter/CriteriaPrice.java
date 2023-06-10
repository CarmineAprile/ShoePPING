package com.example.shoepping.pattern.filter;

import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaPrice implements Criteria{
    @Override
    public Catalog meetCriteria(Catalog catalog, String price) throws ManageException {
        Catalog catalogFind = new Catalog();
        double priceDouble;

        try {
            priceDouble = Double.parseDouble(price);
        }catch (Exception e){
            throw new ManageException("Price error format: " + e.getMessage());
        }

        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoePrice() <= priceDouble){
                catalogFind.addItem(catalogItem);
            }
        }

        return catalogFind;
    }
}
