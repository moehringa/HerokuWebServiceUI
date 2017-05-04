package com.example.domain;


public class OrderDetail {

  private long id;
  private String order_id;
  private Integer quantity;
  private String product;

  public long getId() {
    return id;
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }
}
