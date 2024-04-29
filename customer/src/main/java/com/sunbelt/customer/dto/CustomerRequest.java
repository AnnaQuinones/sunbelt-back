package com.sunbelt.customer.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CustomerRequest implements Serializable {
    private String documentType;
    private String documentNumber;
}
