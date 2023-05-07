package com.example.shoepping.model.catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements ICatalog{

    List<CatalogItem> catalog = new ArrayList<>();

    @Override
    public void addItem(CatalogItem catalogItem) {
        this.catalog.add(catalogItem);
    }

    @Override
    public List<CatalogItem> getCatalog() {
        return catalog;
    }
}
