package com.northwind.northwind.services;

import com.northwind.northwind.dto.EmployeeDto;
import com.northwind.northwind.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    //Get
    List<Employee> findAll();

    //Get by ID
    Optional<Employee> findById(int id);

    //Delete
    Employee deleteById(int id);

    //Post
    Employee saveAndFlush(EmployeeDto employee);

    //Update
    Optional<Employee> updateEmployee(Employee employee, int id);
}
