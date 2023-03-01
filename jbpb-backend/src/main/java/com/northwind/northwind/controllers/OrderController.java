package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.OrderDto;
import com.northwind.northwind.entities.Order;
import com.northwind.northwind.mapstruct.mappers.DTOMapper;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.services.OrderDAO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    //Dao
    private OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<OrderDto> getOrders() {
        List<Order> orders;
        List<OrderDto> orderDtos = new ArrayList<>();

        orders = orderDAO.findAll();

        orders.forEach(order -> {
            orderDtos.add(DTOMapperClass.orderInfo(order));
        });

        return orderDtos;
    }

    //Get By Id
    @GetMapping
    @RequestMapping("/get/{id}")
    public OrderDto getOrderById(@PathVariable int id) {
        Optional<Order> orders = orderDAO.findById(id);
        OrderDto order;

        if (orders.isPresent()) {
            //order = DTOMapperClass.orderInfo(orders.get());
            order = DTOMapperClass.orderInfo(orders.get());

            return order;
        }
        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public OrderDto saveOrder(@RequestBody OrderDto orderBody) {
        orderDAO.saveAndFlush(orderBody);

        return orderBody;
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderDAO.deleteById(id);
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public OrderDto updateOrders(@RequestBody Order orderBody, @PathVariable int id) {
        Optional<Order> orders = orderDAO.updateOrder(orderBody, id);
        OrderDto orderDto;

        if (orders.isPresent()) {
            orderDto = DTOMapperClass.orderInfo(orders.get());

            return orderDto;
        }

        return null;
    }
}
