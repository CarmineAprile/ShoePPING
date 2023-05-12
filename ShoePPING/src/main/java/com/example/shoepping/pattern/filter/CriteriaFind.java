package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaFind implements Criteria{

    @Override
    public Catalog meetCriteria(Catalog catalog, String item) {
        Catalog catalogFind = new Catalog();

        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoeItem().equals(item)){
                catalogFind.addItem(catalogItem);
            }
        }

        return catalogFind;
    }
}
