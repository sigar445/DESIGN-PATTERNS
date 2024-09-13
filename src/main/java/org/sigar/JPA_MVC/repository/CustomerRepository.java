package org.sigar.JPA_MVC.repository;

import org.sigar.JPA_MVC.model_entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
