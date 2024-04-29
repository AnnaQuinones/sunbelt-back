package com.sunbelt.customer.controller;

import com.sunbelt.customer.dto.CustomerRequest;
import com.sunbelt.customer.dto.CustomerResponse;
import com.sunbelt.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/customer")
    public CustomerResponse findCustomerByTypeAndNumberDocument(@RequestBody CustomerRequest customerRequest){
        log.info("Ingresando al servicio findCustomerByTypeAndNumberDocument");
        String documentType = customerRequest.getDocumentType();
        String documentNumber = customerRequest.getDocumentNumber();
        return customerService.findCustomerByTypeAndNumberDocument(documentType, documentNumber);
    }
}
