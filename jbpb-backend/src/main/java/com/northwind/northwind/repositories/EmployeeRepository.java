package com.northwind.northwind.repositories;

import com.northwind.northwind.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Modifying
    @Query("UPDATE Employee e SET active = 0 WHERE employee_id = ?1")
    void changeActive(int id);

    @Query("SELECT e FROM Employee e ORDER BY e.employee_id")
    List<Employee> getEmpleados();

    @Query("SELECT e FROM Employee e WHERE employee_id = ?1")
    Optional<Employee> getEmpleadoById(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.employee_id = ?1")
    void deleteEmpleadoById(int id);
}
