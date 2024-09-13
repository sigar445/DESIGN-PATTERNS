package org.sigar.JavaCRef12Part2Lib.chap20_collection.MYCOLLECTION;
import org.junit.jupiter.api.Test;
import org.sigar.Annotations.Customer;
import org.sigar.Annotations.CustomerRepository;
import org.sigar.Annotations.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testSaveAndFind() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Smith");
        customer.setAge(28);

        // Act
        customerService.save(customer);

        // Assert
        List<Customer> foundCustomers = customerService.findCustomersByLastName("Smith");
        assertNotNull(foundCustomers);
        assertTrue(foundCustomers.stream().anyMatch(c -> c.getFirstName().equals("Alice")));
    }
}

