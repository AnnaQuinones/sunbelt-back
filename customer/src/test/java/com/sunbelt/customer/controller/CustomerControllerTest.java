package com.sunbelt.customer.controller;

import com.sunbelt.customer.dto.CustomerRequest;
import com.sunbelt.customer.dto.CustomerResponse;
import com.sunbelt.customer.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class CustomerControllerTest {
    @Mock
    Logger log;
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindCustomerByTypeAndNumberDocument() {
        when(customerService.findCustomerByTypeAndNumberDocument(anyString(), anyString())).thenReturn(loadData());

        CustomerResponse result = customerController.findCustomerByTypeAndNumberDocument(requestData());
        Assertions.assertEquals(loadData(), result);
    }

    private CustomerResponse loadData(){

        CustomerResponse customer = new CustomerResponse();

        customer.setFirstName("Ana");
        customer.setSecondName("Maria");
        customer.setSurname("Quiñones");
        customer.setSecondSurname("Aya");
        customer.setPhone("4141625");
        customer.setAddress("Diagonal 3 #83 02");
        customer.setCityResidence("Bogotá");

        return customer;
    }

    private CustomerRequest requestData(){

        CustomerRequest customerRequest = new CustomerRequest();

        customerRequest.setDocumentType("C");
        customerRequest.setDocumentNumber("10121314");

        return customerRequest;
    }
}
