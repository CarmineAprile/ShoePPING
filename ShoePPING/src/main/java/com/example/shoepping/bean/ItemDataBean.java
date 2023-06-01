package com.example.shoepping.bean;

import java.util.List;

public class ItemDataBean {
    List<String> itemData;

    public ItemDataBean() {
        // empty constructor
    }

    public List<String> getItemData() {
        return itemData;
    }

    public void setItemData(List<String> itemData) {
        this.itemData = itemData;
    }
}
