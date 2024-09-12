package org.sigar.JavaCRef12Part2Lib.chap20_collection.MYCOLLECTION;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sigar.Annotations.Customer;
import org.sigar.Annotations.CustomerRepository;
import org.sigar.Annotations.CustomerService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void testFindCustomersByLastName() {
        // Arrange
        String lastName = "Smith";
        Customer customer1 = new Customer(1L, "John", "Smith", 30);
        Customer customer2 = new Customer(2L, "Jane", "Smith", 25);

        when(customerRepository.findByLastName(lastName)).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        List<Customer> customers = customerService.findCustomersByLastName(lastName);

        // Assert
        assertEquals(2, customers.size());
        assertEquals("Smith", customers.get(0).getLastName());
    }

    @Test
    void testFindByFirstName() {
        // Arrange
        String firstName = "John";
        Customer customer = new Customer(1L, "John", "Doe", 30);

        when(customerRepository.findByFirstName(firstName)).thenReturn(customer);

        // Act
        Customer foundCustomer = customerService.findByFirstName(firstName);

        // Assert
        assertEquals("John", foundCustomer.getFirstName());
    }
}
