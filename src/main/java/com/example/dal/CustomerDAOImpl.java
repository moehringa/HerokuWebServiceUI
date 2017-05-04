package com.example.dal;

import com.example.domain.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override public List<Customer> findCustomersByName(String name) {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
                new Object[] { name },
                (rs, rowNum) ->
                        new Customer(rs.getLong("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"))
        );
    }

    @Override public void createCustomers(List<Object[]> splitUpNames) {
        //splitUpNames is list of object[] where [0] is first name and [1] is the last name
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
    }

    @Override public List<Customer> findAllCustomers() {
        return  jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers ",
            (rs, rowNum) ->
                new Customer(rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"))
        );
    }

    @Override public Optional<Customer> findCustomersByFullName(Customer customer) {
        Object[] name = {customer.getFirstName(),customer.getLastName()};
        return jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name = ? and last_name = ?",
            name,
            (rs, rowNum) -> new Customer(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"))
        ).stream().findFirst();
    }
}
