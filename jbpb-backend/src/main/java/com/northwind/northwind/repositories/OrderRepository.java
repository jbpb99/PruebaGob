package com.northwind.northwind.repositories;

import com.northwind.northwind.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
