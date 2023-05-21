package com.example.shoepping.model.sale_storage;

public interface ISaleStorageItem {
    int getStorageSale();

    String getStorageBrand();

    String getStorageItem();

    double getStoragePrice();

    int getStorageSize();

    String getStorageCondition();

    String getStorageBuyer();

    String getStorageAddress();


    void setStorageSale(int storageSale);

    void setStorageBrand(String storageBrand);

    void setStorageItem(String storageItem);

    void setStoragePrice(double storagePrice);

    void setStorageSize(int storageSize);

    void setStorageCondition(String storageCondition);

    void setStorageBuyer(String storageBuyer);

    void setStorageAddress(String storageAddress);

    void setStorageSeller(String storageSeller);

    void setStorageIsChecked(int storageIsChecked);
}
