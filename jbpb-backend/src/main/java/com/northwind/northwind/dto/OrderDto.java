package com.northwind.northwind.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


public class OrderDto implements Serializable {
    private int order_id;
    private LocalDateTime orderDate;

    private int employee;

    private String  customer;

    private int shipper;

    public OrderDto() {

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getShipper() {
        return shipper;
    }

    public void setShipper(int shipper) {
        this.shipper = shipper;
    }
}
