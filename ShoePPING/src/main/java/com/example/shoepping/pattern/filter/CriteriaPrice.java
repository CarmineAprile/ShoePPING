package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaPrice implements Criteria{
    @Override
    public Catalog meetCriteria(Catalog catalog, String price) {
        Catalog catalogFind = new Catalog();

        double priceDouble = Double.parseDouble(price);

        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoePrice() <= priceDouble){
                catalogFind.addItem(catalogItem);
            }
        }

        return catalogFind;
    }
}
