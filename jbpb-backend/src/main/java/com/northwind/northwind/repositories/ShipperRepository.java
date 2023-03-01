package com.northwind.northwind.repositories;

import com.northwind.northwind.entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
    @Modifying
    @Query("UPDATE Shipper s SET active = 0 WHERE shipper_id = ?1")
    void changeActive(int id);
}
