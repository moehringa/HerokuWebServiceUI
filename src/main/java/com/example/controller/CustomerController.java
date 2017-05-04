package com.example.controller;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/findCustomers/{firstName}")
    @ResponseBody
    public List<Customer> findCustomerByName(@PathVariable("firstName")String firstName) {
        return customerService.findCustomer(firstName);
    }

    @RequestMapping(value = "/showAllCustomers")
    public String findAllCustomers( Model model) {
        model.addAttribute("customers", customerService.findAllCustomers());
        return "showAllCustomers.html";
    }

    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer.html";
    }

    @RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
    public String addNewCustomer(@ModelAttribute Customer customer, Model model) {

        customerService.createCustomer(customer.getFirstName(),customer.getLastName());
        Customer added = customerService.findCustomerByName(customer);
        model.addAttribute("addedCustomer", added);

        return "newusergreeting.html";
    }

}
