package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.OrderDetailDto;
import com.northwind.northwind.entities.OrderDetail;
import com.northwind.northwind.mapstruct.mappers.DTOMapperClass;
import com.northwind.northwind.services.OrderDetailDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {
    private OrderDetailDAO orderDetailDAO;

    public OrderDetailController(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO = orderDetailDAO;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<OrderDetailDto> getOrderDetail() {
        List<OrderDetail> details = orderDetailDAO.findAll();
        List<OrderDetailDto> orderDetailDto = new ArrayList<>();

        details.forEach(orderDetail -> {
            orderDetailDto.add(DTOMapperClass.orderDetailDto(orderDetail));
        });

        return orderDetailDto;
    }

    //Get By Id
    @GetMapping
    @RequestMapping("/get/{id}")
    public OrderDetailDto getOrderDetailById(@PathVariable int id) {
        Optional<OrderDetail> details = orderDetailDAO.findById(id);
        OrderDetailDto detailDto;

        if(details.isPresent()) {
            detailDto = DTOMapperClass.orderDetailDto(details.get());

            return detailDto;
        }

        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public OrderDetailDto saveOrderDetail(@RequestBody OrderDetailDto orderDetailBody) {
        orderDetailDAO.saveAndFlush(orderDetailBody);

        return orderDetailBody;
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteOrderDetail(@PathVariable int id) {
        orderDetailDAO.deleteById(id);
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public OrderDetailDto updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable int id) {
        Optional<OrderDetail> details = orderDetailDAO.updateOrderDetail(orderDetail, id);
        OrderDetailDto detailDto;

        if(details.isPresent()) {
            detailDto = DTOMapperClass.orderDetailDto(details.get());

            return detailDto;
        }

        return null;
    }
}
