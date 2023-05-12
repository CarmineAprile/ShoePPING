package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaSize implements Criteria{
    @Override
    public Catalog meetCriteria(Catalog catalog, String size) {
        Catalog catalogFind = new Catalog();


        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(String.valueOf(catalogItem.getShoeSize()).equals(size)){
                catalogFind.addItem(catalogItem);
            }
        }

        return catalogFind;
    }
}
