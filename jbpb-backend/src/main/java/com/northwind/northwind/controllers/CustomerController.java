package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.CategoryDto;
import com.northwind.northwind.dto.CustomerDto;
import com.northwind.northwind.entities.Category;
import com.northwind.northwind.entities.Customer;
import com.northwind.northwind.mapstruct.mappers.DTOMapper;
import com.northwind.northwind.services.CategoryDAO;
import com.northwind.northwind.services.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerDAO customerDAO;

    private DTOMapper dtoMapper;

    @Autowired
    public CustomerController(CustomerDAO customerDAO, DTOMapper dtoMapper) {
        this.customerDAO = customerDAO;
        this.dtoMapper = dtoMapper;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<CustomerDto> getCustomers() {
        List<Customer> customers;
        List<CustomerDto> customerDtos = new ArrayList<>();

        customers = customerDAO.findAll();
        customers.forEach(customer -> {
            customerDtos.add(dtoMapper.customerDTO(customer));
        });

        return customerDtos;
    }

    //GetbyID
    @RequestMapping("/get/{id}")
    public CustomerDto getCustomerById(@PathVariable String id) {
        Optional<Customer> customers;
        CustomerDto customerDto;

        customers = customerDAO.findById(id);

        if(customers.isPresent()) {
            customerDto = dtoMapper.customerDTO(customers.get());

            return customerDto;
        }
        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public Customer saveCustomer(@RequestBody Customer customerBody) {
        customerDAO.saveAndFlush(customerBody);

        return customerBody;
    }

    //Delete
    @RequestMapping("/delete/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        customerDAO.deleteById(id);

        return null;
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public CustomerDto updateCustomer(@RequestBody Customer customerBody, @PathVariable int id) {
        Optional<Customer> customer = customerDAO.updateCustomer(customerBody, id);
        CustomerDto customerDto;

        if(customer.isPresent()) {
            customerDto = dtoMapper.customerDTO(customer.get());

            return customerDto;
        }


        return null;
    }


}
