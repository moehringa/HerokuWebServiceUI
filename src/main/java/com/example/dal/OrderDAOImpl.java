package com.example.dal;

import com.example.domain.Order;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDAOImpl implements OrderDAO {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override public List<Order> findOrderByCustomer(long customer_id) {
    return jdbcTemplate.query(
        "SELECT id, order_id, customer_id FROM orders WHERE customer_id = ?",
        new Object[]{customer_id},
        (rs, rowNum) ->
            new Order(rs.getLong("id"),
                rs.getString("order_id"),
                rs.getLong("customer_id"))
    );
  }

  @Override public void createOrders(List<Order> orders) {
    String insert = "INSERT INTO orders(order_id, customer_id) VALUES (?,?)";
    jdbcTemplate.batchUpdate(insert, new BatchPreparedStatementSetter() {
      @Override public void setValues(PreparedStatement ps, int i) throws SQLException {
        Order o = orders.get(i);
        ps.setString(1, o.getOrder_id());
        ps.setLong(2, o.getCustomer_id());
      }

      @Override public int getBatchSize() {
        return orders.size();
      }
    });
  }
}
