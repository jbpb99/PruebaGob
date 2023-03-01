package com.northwind.northwind.services.impl;

import com.northwind.northwind.dto.OrderDetailDto;
import com.northwind.northwind.entities.Order;
import com.northwind.northwind.entities.OrderDetail;
import com.northwind.northwind.entities.Product;
import com.northwind.northwind.repositories.OrderDetailRepository;
import com.northwind.northwind.repositories.OrderRepository;
import com.northwind.northwind.repositories.ProductRepository;
import com.northwind.northwind.services.OrderDetailDAO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(int id) {
        return (Optional<OrderDetail>) orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail saveAndFlush(OrderDetailDto orderDetailDto) {
        Optional<Order> order = orderRepository.findById(orderDetailDto.getOrder());
        Optional<Product> product = productRepository.findById(orderDetailDto.getProduct());
        OrderDetail orderDetail = new OrderDetail();

        if(order.isPresent()) {
            orderDetail.setOrder(order.get());
        }else {
            return null;
        }
        if(product.isPresent()) {
            orderDetail.setProduct(product.get());
        }else {
            return null;
        }

        orderDetail.setQuantity(orderDetailDto.getQuantity());

        return null;
    }


    @Override
    public void deleteById(int id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> saveAndFlush(OrderDetail orderDetail) {
        orderDetailRepository.saveAndFlush(orderDetail);
        return null;
    }

    @Override
    public Optional<OrderDetail> updateOrderDetail(OrderDetail orderDetail, int id) {
        Optional<OrderDetail> details = orderDetailRepository.findById(id);
        OrderDetail detailsObj;

        if(details.isPresent()) {
            detailsObj = details.get();

            detailsObj.setQuantity(orderDetail.getQuantity());

            orderDetailRepository.saveAndFlush(detailsObj);

            return Optional.of(detailsObj);
        }

        return Optional.empty();
    }
}
