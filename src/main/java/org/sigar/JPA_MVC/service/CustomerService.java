package org.sigar.JPA_MVC.service;


import org.sigar.JPA_MVC.model_entity.Customer;
import org.sigar.JPA_MVC.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        System.out.println(customer);
        return customerRepository.save(customer);
    }
}

