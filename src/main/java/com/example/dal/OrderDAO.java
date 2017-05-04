package com.example.dal;

import com.example.domain.Order;
import java.util.List;

public interface OrderDAO {

  List<Order> findOrderByCustomer(long customer_id);
  void createOrders(List<Order> orders);
}
