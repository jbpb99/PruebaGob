package com.northwind.northwind.controllers;

import com.northwind.northwind.dto.EmployeeDto;
import com.northwind.northwind.entities.Employee;
import com.northwind.northwind.mapstruct.mappers.DTOMapper;
import com.northwind.northwind.services.EmployeeDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //DAO
    private EmployeeDAO employeeDAO;

    //Mapper for Employee
    private DTOMapper dtoMapper;
    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO, DTOMapper dtoMapper) {
        this.employeeDAO = employeeDAO;
        this.dtoMapper = dtoMapper;
    }

    //Get
    @GetMapping
    @RequestMapping("/get")
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees;
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        employees = employeeDAO.findAll();

        employees.forEach(employee -> {
            employeeDtos.add(dtoMapper.employeeDto(employee));
        });
        return employeeDtos;
    }

    //Get By ID
    @GetMapping
    @RequestMapping("/get/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        Optional<Employee> employees;
        EmployeeDto employee;

        employees = employeeDAO.findById(id);

        if(employees.isPresent()) {
            employee = dtoMapper.employeeDto(employees.get());

            return employee;
        }

        return null;
    }

    //Post
    @PostMapping
    @RequestMapping("/post")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeBody) {
        employeeDAO.saveAndFlush(employeeBody);

        return employeeBody;
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        employeeDAO.deleteById(id);

        return null;
    }

    //Update
    @PutMapping
    @RequestMapping("/update/{id}")
    public EmployeeDto updateEmployee(@RequestBody Employee employeeBody, @PathVariable int id) {
        Optional<Employee> employees = employeeDAO.updateEmployee(employeeBody, id);
        EmployeeDto employeeDto;

        if(employees.isPresent()) {
            employeeDto = dtoMapper.employeeDto(employees.get());

            return employeeDto;
        }

        return null;
    }
}
