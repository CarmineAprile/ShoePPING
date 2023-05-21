package com.example.shoepping.model.sale_storage;

public class SaleStorageItem implements ISaleStorageItem{

    private int storageSale;
    private String storageBrand;
    private String storageItem;
    private double storagePrice;
    private int storageSize;
    private String storageCondition;
    private String storageBuyer;
    private String storageAddress;
    private String storageSeller;
    private int storageIsChecked;

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

    public SaleStorageItem() {

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

    public String getStorageSeller() {
        return storageSeller;
    }

    public int getStorageIsChecked() {
        return storageIsChecked;
    }

    @Override
    public void setStorageSale(int storageSale) {
        this.storageSale = storageSale;
    }
    @Override
    public void setStorageBrand(String storageBrand) {
        this.storageBrand = storageBrand;
    }
    @Override
    public void setStorageItem(String storageItem) {
        this.storageItem = storageItem;
    }
    @Override
    public void setStoragePrice(double storagePrice) {
        this.storagePrice = storagePrice;
    }
    @Override
    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
    @Override
    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }
    @Override
    public void setStorageBuyer(String storageBuyer) {
        this.storageBuyer = storageBuyer;
    }

    @Override
    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    @Override
    public void setStorageSeller(String storageSeller) {
        this.storageSeller = storageSeller;
    }

    @Override
    public void setStorageIsChecked(int storageIsChecked) {
        this.storageIsChecked = storageIsChecked;
    }

    @Override
    public String toString(){
        return "Sale: " + this.getStorageSale() + ", " + this.getStorageBrand() + ", " + this.getStorageItem() + ", " + this.getStoragePrice() + "$, " +  this.getStorageSize() + ", " + this.getStorageCondition() + ", " + this.getStorageBuyer() + ", " + this.getStorageAddress();
    }
}
