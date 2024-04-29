package com.sunbelt.customer.service;

import com.sunbelt.customer.dto.CustomerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    Logger log;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindCustomerByTypeAndNumberDocument() {
        CustomerResponse result = customerService.findCustomerByTypeAndNumberDocument("C", "10121314");
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
}