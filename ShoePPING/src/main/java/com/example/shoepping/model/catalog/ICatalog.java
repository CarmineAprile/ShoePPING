package com.example.shoepping.model.catalog;

import java.util.List;

public interface ICatalog {
    void addItem(CatalogItem catalogItem);

    List<CatalogItem> getCatalog();
}
