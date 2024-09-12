package org.sigar.Annotations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Finds a single customer by first name
   // Customer findByFirstName(String firstName);
    @Query("SELECT c FROM Customer c WHERE TRIM(c.firstName) = :firstName")
    Customer findByFirstName(@Param("firstName") String firstName);

    // Finds all customers with the given last name
    List<Customer> findByLastName(String lastName);
}
