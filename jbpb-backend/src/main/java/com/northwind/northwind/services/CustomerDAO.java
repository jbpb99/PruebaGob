package com.northwind.northwind.services;

import com.northwind.northwind.dto.CustomerDto;
import com.northwind.northwind.entities.Category;
import com.northwind.northwind.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    //Get
    List<Customer> findAll();
    //Get by ID
    Optional<Customer> findById(String id);

    //Post
    //List<Category> save(Category category);

    //Delete
    Customer deleteById(int id);

    //New post
    Customer saveAndFlush(CustomerDto customer);

    //Update
    //Optional<Category> updateCategory(Category category, int id);

    //Update
    Optional<Customer> updateCustomer(Customer customer, int id);
}
