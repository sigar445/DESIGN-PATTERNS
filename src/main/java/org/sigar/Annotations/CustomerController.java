package org.sigar.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @GetMapping("/byFirstName/{firstName}")
//    public Customer getCustomerByFirstName(@PathVariable String firstName){
//        return customerService.findByFirstName(firstName);
//    }
    @GetMapping("/byFirstName/{firstName}")
    public ResponseEntity<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        Customer customer = customerService.findByFirstName(firstName);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }


    @GetMapping("/byLastName/{lastName}")
    public List<Customer> getCustomerByLastName(@PathVariable String lastName){
        return customerService.findCustomersByLastName(lastName);
    }

    @PostMapping()
    public Customer saveCustomer(@RequestBody Customer customer){
         customerService.save(customer);
         return customer;
    }
}
