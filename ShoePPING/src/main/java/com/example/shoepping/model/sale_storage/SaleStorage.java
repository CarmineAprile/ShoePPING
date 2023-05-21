package com.example.shoepping.model.sale_storage;


import java.util.ArrayList;
import java.util.List;

public class SaleStorage implements ISaleStorage{

    List<SaleStorageItem> saleStorageItems = new ArrayList<>();

    @Override
    public void addItem(SaleStorageItem saleStorageItem) {
        this.saleStorageItems.add(saleStorageItem);
    }

    @Override
    public List<SaleStorageItem> getCatalog() {
        return saleStorageItems;
    }
}
