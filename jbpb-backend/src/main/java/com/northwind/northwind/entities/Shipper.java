package com.northwind.northwind.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Table(name = "Shippers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Shipper_ID")
    private int shipper_id;

    @Column(name = "company_name")
    private String shipperName;

    @Column(name = "Phone")
    private String phone;

    //list to bring the orders by shipper
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipper", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "shipper"})
    private List<Order> orders;

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
