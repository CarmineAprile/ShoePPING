package com.example.shoepping.model.order;

import java.util.ArrayList;
import java.util.List;

public class OrderList implements IOrderList{

    List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Order order : orders){
            sb.append(order.toString()).append("\n\n");
        }

        return sb.toString();
    }

    @Override
    public List<Order> getOrderList() {
        return orders;
    }
}
