package com.example.shoepping.model.catalog;

public class CatalogItem implements ICatalogItem{


    private final int shoeSale;
    private final String shoeBrand;
    private final String shoeItem;
    private  final double shoePrice;
    private final int shoeSize;
    private final String shoeUsername;
    private final String shoeCondition;

    public CatalogItem(int shoeSale, String shoeBrand, String shoeItem, double shoePrice, int shoeSize, String shoeUsername, String shoeCondition) {
        this.shoeSale = shoeSale;
        this.shoeBrand = shoeBrand;
        this.shoeItem = shoeItem;
        this.shoePrice = shoePrice;
        this.shoeSize = shoeSize;
        this.shoeUsername = shoeUsername;
        this.shoeCondition = shoeCondition;
    }

    @Override
    public int getShoeSale() {
        return shoeSale;
    }

    @Override
    public String getShoeBrand() {
        return shoeBrand;
    }

    @Override
    public String getShoeItem() {
        return shoeItem;
    }

    @Override
    public double getShoePrice() {
        return shoePrice;
    }

    @Override
    public int getShoeSize() {
        return shoeSize;
    }

    @Override
    public String getShoeUsername() {
        return shoeUsername;
    }

    @Override
    public String getShoeCondition() {
        return shoeCondition;
    }

    @Override
    public String toString(){
        return "Sale: " + this.getShoeSale() + ", " + this.getShoeBrand() + ", " + this.getShoeItem() + ", " + this.getShoePrice() + "$, " + this.getShoeSize() + ", " + this.getShoeCondition() + "      User: " + this.getShoeUsername();
    }

    public String toStringSales(){
        return "Sale:\t\t\t" + this.getShoeSale() + "\nBrand:\t\t" + this.getShoeBrand() + "\nItem:\t\t" + this.getShoeItem() + "\nPrice:\t\t" + this.getShoePrice() + "$\nSize:\t\t\t" + this.getShoeSize() + "\nCondition:\t" + this.getShoeCondition();
    }
}
