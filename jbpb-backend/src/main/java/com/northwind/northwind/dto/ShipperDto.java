package com.northwind.northwind.dto;

import com.northwind.northwind.entities.Shipper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ShipperDto implements Serializable {
    private  int shipper_id;
    private  String shipperName;
    private  String phone;

    public ShipperDto() {

    }

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
}
