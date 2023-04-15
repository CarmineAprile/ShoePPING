package com.example.shoepping.model.order;

public class Order implements IOrder{

    private final int order;
    private final String dateOrder;
    private final String itemOrder;
    private  final double priceOrder;
    private final String conditionOrder;
    private final String addressOrder;
    private final String statusOrder;

    public Order(int order, String dateOrder, String itemOrder, double priceOrder, String conditionOrder, String addressOrder, String statusOrder) {
        this.order = order;
        this.dateOrder = dateOrder;
        this.itemOrder = itemOrder;
        this.priceOrder = priceOrder;
        this.conditionOrder = conditionOrder;
        this.addressOrder = addressOrder;
        this.statusOrder = statusOrder;
    }

    @Override
    public int getOrder() {
        return order;
    }
    @Override
    public String getDateOrder() {
        return dateOrder;
    }
    @Override
    public String getItemOrder() {
        return itemOrder;
    }
    @Override
    public double getPriceOrder() {
        return priceOrder;
    }
    @Override
    public String getConditionOrder() {
        return conditionOrder;
    }
    @Override
    public String getAddressOrder() {
        return addressOrder;
    }
    @Override
    public String getStatusOrder() {
        return statusOrder;
    }

    @Override
    public String toString(){
        return "Order:\t\t" + this.getOrder() + "\nDate:\t\t" + this.getDateOrder() + "\nItem:\t\t" + this.getItemOrder() + "\nPrice:\t\t" + this.getPriceOrder() + "$\nCondition:\t" + this.getConditionOrder() + "\nAddress:\t\t" + this.getAddressOrder() + "\nStatus:\t\t" + this.getStatusOrder();
    }
}
