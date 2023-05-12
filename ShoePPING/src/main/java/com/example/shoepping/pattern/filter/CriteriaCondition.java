package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaCondition implements Criteria{
    @Override
    public Catalog meetCriteria(Catalog catalog, String condition) {
        Catalog catalogFind = new Catalog();

        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoeCondition().equals(condition.toLowerCase())){
                catalogFind.addItem(catalogItem);
            }
        }
        return catalogFind;    }
}
