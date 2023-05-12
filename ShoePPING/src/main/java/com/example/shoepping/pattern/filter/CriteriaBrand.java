package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;

public class CriteriaBrand implements Criteria{
    @Override
    public Catalog meetCriteria(Catalog catalog, String brand) {
        Catalog catalogFind = new Catalog();

        for(CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoeBrand().equals(brand.toLowerCase())){
                catalogFind.addItem(catalogItem);
            }
        }

        return catalogFind;
    }
}
