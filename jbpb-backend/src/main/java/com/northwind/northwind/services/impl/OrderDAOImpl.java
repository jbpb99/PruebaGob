package com.northwind.northwind.services.impl;

import com.northwind.northwind.dto.OrderDto;
import com.northwind.northwind.entities.Customer;
import com.northwind.northwind.entities.Employee;
import com.northwind.northwind.entities.Order;
import com.northwind.northwind.entities.Shipper;
import com.northwind.northwind.repositories.CustomerRepository;
import com.northwind.northwind.repositories.EmployeeRepository;
import com.northwind.northwind.repositories.OrderRepository;
import com.northwind.northwind.repositories.ShipperRepository;
import com.northwind.northwind.services.OrderDAO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ShipperRepository shipperRepository;

    //Get
    @Transactional(readOnly = true)
    @Override
    public List<Order> findAll() {
       return (List<Order>) orderRepository.findAll();

    }

    //Get By Id
    @Override
    public Optional<Order> findById(int id) {
        return (Optional<Order>) orderRepository.findById(id);
    }

    @Override
    public Order saveAndFlush(OrderDto orderDto) {
        Order order = new Order();
        Optional<Employee> employee = employeeRepository.findById(orderDto.getEmployee());
        Optional<Customer> customer = customerRepository.findById(orderDto.getCustomer());
        Optional<Shipper> shipper = shipperRepository.findById(orderDto.getShipper());

        if(customer.isPresent()) {
            order.setCustomer(customer.get());
        }else {
            return null;
        }
        if(employee.isPresent()) {
            order.setEmployee(employee.get());
        }else {
            return null;
        }
        if(shipper.isPresent()) {
            order.setShipper(shipper.get());
        }else {
            return null;
        }
        order.setOrderDate(orderDto.getOrderDate());

        orderRepository.saveAndFlush(order);

        return null;
    }

    //Delete
    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);

    }

    //Update
    @Override
    public Optional<Order> updateOrder(Order order, int id) {
        Optional<Order> orders = orderRepository.findById(id);
        Order orderObj;

        if(orders.isPresent()) {
            orderObj = orders.get();

            orderObj.setOrderDate(order.getOrderDate());

            orderRepository.saveAndFlush(orderObj);

            return Optional.of(orderObj);
        }

        return Optional.empty();
    }
}
