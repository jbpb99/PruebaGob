package com.northwind.northwind.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
public class CustomerDto implements Serializable {
    @JsonProperty("customer_id")
    private final String customer_id;
    @JsonProperty("customerName")
    private final String customerName;
    @JsonProperty("contactName")
    private final String contactName;
    @JsonProperty("address")
    private final String address;
    @JsonProperty("city")
    private final String city;
    @JsonProperty("postalCode")
    private final String postalCode;
    @JsonProperty("country")
    private final String country;

    public CustomerDto(String customer_id, String customerName, String contactName, String address, String city, String postalCode, String country) {
        this.customer_id = customer_id;
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
