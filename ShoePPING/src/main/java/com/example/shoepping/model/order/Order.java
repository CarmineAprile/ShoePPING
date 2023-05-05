package com.example.shoepping.model.order;

public class Order implements IOrder{

    private int orderID;
    private final String dateOrder;
    private final String itemOrder;
    private  final double priceOrder;
    private final String conditionOrder;
    private final String addressOrder;
    private final String statusOrder;

    public Order(int orderID, String dateOrder, String itemOrder, double priceOrder, String conditionOrder, String addressOrder, String statusOrder) {
        this.orderID = orderID;
        this.dateOrder = dateOrder;
        this.itemOrder = itemOrder;
        this.priceOrder = priceOrder;
        this.conditionOrder = conditionOrder;
        this.addressOrder = addressOrder;
        this.statusOrder = statusOrder;
    }

    public Order(String dateOrder, String itemOrder, double priceOrder, String conditionOrder, String addressOrder, String statusOrder) {
        this.dateOrder = dateOrder;
        this.itemOrder = itemOrder;
        this.priceOrder = priceOrder;
        this.conditionOrder = conditionOrder;
        this.addressOrder = addressOrder;
        this.statusOrder = statusOrder;
    }

    @Override
    public int getOrder() {
        return orderID;
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
    public int isValid() {
        // 0. Check for address is empty
        if (addressOrder.isEmpty())
            return 0;
        else return -1;
    }

    @Override
    public String toString(){
        return "Order:\t\t" + this.getOrder() + "\nDate:\t\t" + this.getDateOrder() + "\nItem:\t\t" + this.getItemOrder() + "\nPrice:\t\t" + this.getPriceOrder() + "$\nCondition:\t" + this.getConditionOrder() + "\nAddress:\t\t" + this.getAddressOrder() + "\nStatus:\t\t" + this.getStatusOrder();
    }
}
