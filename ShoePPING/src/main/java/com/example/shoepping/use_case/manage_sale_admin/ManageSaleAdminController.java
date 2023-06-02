package com.example.shoepping.use_case.manage_sale_admin;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;
import com.example.shoepping.dao.order_dao.OrderDaoJDBC;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.order.OrderList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageSaleAdminController implements IManageSaleAdminController {
    IManageSaleAdminView manageSaleAdminView;

    public ManageSaleAdminController(IManageSaleAdminView manageSaleAdminView) {
        this.manageSaleAdminView = manageSaleAdminView;
    }

    @Override
    public void getSales() throws SQLException, IOException, ClassNotFoundException {

        OrderDaoJDBC orderDaoJDBC = new OrderDaoJDBC();
        OrderList orderList = orderDaoJDBC.getManageSalesListAdmin();

        for (Order order : orderList.getOrderList()) {
            List<String> itemData = new ArrayList<>();              //All strings!
            itemData.add(String.valueOf(order.getOrder()));         //index 0: orderID
            itemData.add(order.getDateOrder());                     //index 1: dateOrder
            itemData.add(order.getItemOrder());                     //index 2: Item
            itemData.add(String.valueOf(order.getPriceOrder()));    //index 3: Price
            itemData.add(order.getConditionOrder());                //index 4: Condition
            itemData.add(order.getAddressOrder());                  //index 5: Address
            itemData.add(order.getStatusOrder());                   //index 6: Status


            SaleBean orderBean = new SaleBean();
            ItemDataBean itemDataBean = new ItemDataBean();

            orderBean.setSale(order.toStringManage());
            itemDataBean.setItemData(itemData);

            manageSaleAdminView.setSaleButton(orderBean, itemDataBean);
        }
    }

    @Override
    public void onConfirmOrder(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException {

        OrderDaoJDBC orderDao = new OrderDaoJDBC();
        Order order = new Order(Integer.parseInt(itemData.getItemData().get(0)), itemData.getItemData().get(1), itemData.getItemData().get(2), Double.parseDouble(itemData.getItemData().get(3)), itemData.getItemData().get(4), itemData.getItemData().get(5), itemData.getItemData().get(6));

        orderDao.confirmOrder(order);
    }

    @Override
    public void onRefuseOrder(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException {

        OrderDaoJDBC orderDao = new OrderDaoJDBC();
        Order order = new Order(Integer.parseInt(itemData.getItemData().get(0)), itemData.getItemData().get(1), itemData.getItemData().get(2), Double.parseDouble(itemData.getItemData().get(3)), itemData.getItemData().get(4), itemData.getItemData().get(5), itemData.getItemData().get(6));

        orderDao.refuseOrder(order);

    }
}
