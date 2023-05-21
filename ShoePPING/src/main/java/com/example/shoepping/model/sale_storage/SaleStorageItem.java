package com.example.shoepping.model.sale_storage;

public class SaleStorageItem implements ISaleStorageItem{

    private final int storageSale;
    private final String storageBrand;
    private final String storageItem;
    private  final double storagePrice;
    private final int storageSize;
    private final String storageCondition;
    private final String storageBuyer;
    private final String storageAddress;
    private final String storageSeller;
    private final int storageIsChecked;


    public SaleStorageItem(int storageSale, String storageBrand, String storageItem, double storagePrice, int storageSize, String storageCondition, String storageBuyer, String storageAddress, String storageSeller, int storageIsChecked) {
        this.storageSale = storageSale;
        this.storageBrand = storageBrand;
        this.storageItem = storageItem;
        this.storagePrice = storagePrice;
        this.storageSize = storageSize;
        this.storageCondition = storageCondition;
        this.storageBuyer = storageBuyer;
        this.storageAddress = storageAddress;
        this.storageSeller = storageSeller;
        this.storageIsChecked = storageIsChecked;
    }

    @Override
    public int getStorageSale() {
        return storageSale;
    }
    @Override
    public String getStorageBrand() {
        return storageBrand;
    }
    @Override
    public String getStorageItem() {
        return storageItem;
    }
    @Override
    public double getStoragePrice() {
        return storagePrice;
    }
    @Override
    public int getStorageSize() {
        return storageSize;
    }
    @Override
    public String getStorageCondition() {
        return storageCondition;
    }
    @Override
    public String getStorageBuyer() {
        return storageBuyer;
    }
    @Override
    public String getStorageAddress(){return storageAddress;}
    @Override
    public String getStorageSeller() {
        return storageSeller;
    }
    @Override
    public int getStorageIsChecked() {
        return storageIsChecked;
    }

    @Override
    public String toString(){
        return "Sale: " + this.getStorageSale() + ", " + this.getStorageBrand() + ", " + this.getStorageItem() + ", " + this.getStoragePrice() + "$, " +  this.getStorageSize() + ", " + this.getStorageCondition() + ", " + this.getStorageBuyer() + ", " + this.getStorageAddress();
    }
}
