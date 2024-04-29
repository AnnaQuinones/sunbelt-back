package com.sunbelt.customer.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CustomerResponse implements Serializable {
    private String firstName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private String phone;
    private String address;
    private String cityResidence;
}
