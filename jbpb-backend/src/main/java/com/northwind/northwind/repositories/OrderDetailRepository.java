package com.northwind.northwind.repositories;

import com.northwind.northwind.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
