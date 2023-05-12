package com.example.shoepping.model.catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements ICatalog{

    List<CatalogItem> shoeCatalog = new ArrayList<>();

    @Override
    public void addItem(CatalogItem catalogItem) {
        this.shoeCatalog.add(catalogItem);
    }

    @Override
    public List<CatalogItem> getCatalog() {
        return shoeCatalog;
    }
}
