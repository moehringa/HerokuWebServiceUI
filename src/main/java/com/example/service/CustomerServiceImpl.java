package com.example.service;

import com.example.dal.CustomerDAO;
import com.example.dal.CustomerDAOImpl;
import com.example.domain.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void createCustomer(String first, String last) {
        Object[] name = {first,last};
        List<Object[]> names_list = new ArrayList<>();
        names_list.add(name);

        customerDAO.createCustomers(names_list);

    }

    public List<Customer> findCustomer(String firstName) {
        return customerDAO.findCustomersByName(firstName);
    }

    @Override public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @Override public Customer findCustomerByName(Customer newCustomer) {
        Optional<Customer> customer = customerDAO.findCustomersByFullName(newCustomer);
        return customer.orElse(new Customer(-1L,"",""));
    }

}
