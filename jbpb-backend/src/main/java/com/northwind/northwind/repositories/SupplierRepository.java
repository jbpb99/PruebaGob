package com.northwind.northwind.repositories;

import com.northwind.northwind.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Modifying
    @Query("UPDATE Supplier s SET active = 0 WHERE supplier_id = ?1")
    void changeActive(int id);
}
