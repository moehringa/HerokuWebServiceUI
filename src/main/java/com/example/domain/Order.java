package com.example.domain;

public class Order {
  private long id;
  private String order_id;
  private long customer_id;

  public long getId() {
    return id;
  }

  public Order(long id, String order_id, long customer_id) {
    this.id = id;
    this.order_id = order_id;
    this.customer_id = customer_id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOrder_id() {
    return order_id;
  }

  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public long getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(long customer_id) {
    this.customer_id = customer_id;
  }
}
