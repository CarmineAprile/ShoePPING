package com.example.shoepping.model.order;

import java.util.List;

public interface IOrderList {

    void addOrder(Order order);

    List<Order> getOrderList();
}
