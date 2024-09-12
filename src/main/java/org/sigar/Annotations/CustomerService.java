package org.sigar.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> findCustomersByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName.trim());
    }

}
