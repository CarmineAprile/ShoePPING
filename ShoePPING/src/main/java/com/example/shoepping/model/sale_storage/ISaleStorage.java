package com.example.shoepping.model.sale_storage;

import java.util.List;

public interface ISaleStorage {
    void addItem(SaleStorageItem saleStorageItem);
    List<SaleStorageItem> getCatalog();
}
