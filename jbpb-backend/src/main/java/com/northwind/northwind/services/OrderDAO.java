package com.northwind.northwind.services;

import com.northwind.northwind.dto.OrderDto;
import com.northwind.northwind.entities.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    //Get
    List<Order> findAll();

    //GetById
    Optional<Order> findById(int id);

    //Post
    Order saveAndFlush(OrderDto order);

    //Delete
    void deleteById(int id);

    //Put
    Optional<Order> updateOrder(Order order, int id);


}
