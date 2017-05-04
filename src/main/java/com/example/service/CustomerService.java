package com.example.service;


import com.example.domain.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(String first, String last);
    List<Customer> findCustomer(String firstName);
    List<Customer> findAllCustomers();
    Customer findCustomerByName(Customer newCustomer);
}
