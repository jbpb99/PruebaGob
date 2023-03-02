package com.northwind.northwind.services.impl;

import com.northwind.northwind.dto.EmployeeDto;
import com.northwind.northwind.entities.Employee;
import com.northwind.northwind.repositories.EmployeeRepository;
import com.northwind.northwind.services.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Get
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.getEmpleados();
    }

    //Get by ID
    @Override
    public Optional<Employee> findById(int id) {
        return (Optional<Employee>) employeeRepository.getEmpleadoById(id);
    }

    //Delete
    @Override
    public Employee deleteById(int id) {
        employeeRepository.deleteEmpleadoById(id);

        return null;
    }

    //Post
    @Override
    public Employee saveAndFlush(EmployeeDto employee) {
        Employee employee1 = new Employee();

        employee1.setEmployee_id(employee.getEmployee_id());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setBirthDate(employee.getBirthDate());
        employee1.setNotes(employee.getNotes());

        employeeRepository.saveAndFlush(employee1);

        return null;
    }

    //Put
    @Override
    public Optional<Employee> updateEmployee(Employee employee, int id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        Employee employeeObj;

        if(employees.isPresent()) {
            employeeObj = employees.get();

            employeeObj.setLastName(employee.getLastName());
            employeeObj.setFirstName(employee.getFirstName());
            employeeObj.setBirthDate(employee.getBirthDate());
            employeeObj.setNotes(employee.getNotes());

            employeeRepository.saveAndFlush(employeeObj);

            return Optional.of(employeeObj);

        }

        return Optional.empty();
    }
}
