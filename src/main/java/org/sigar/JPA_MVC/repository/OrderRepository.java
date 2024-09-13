package org.sigar.JPA_MVC.repository;

import org.sigar.JPA_MVC.model_entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
