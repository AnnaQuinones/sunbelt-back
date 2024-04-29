package com.sunbelt.customer.service;

import com.sunbelt.customer.dto.CustomerResponse;
import com.sunbelt.customer.exceptions.BadRequestException;
import com.sunbelt.customer.exceptions.InternalServerException;
import com.sunbelt.customer.exceptions.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    Logger log = LoggerFactory.getLogger(CustomerService.class);

    private static final String CITIZENSHIP_CARD = "C";
    private static final String PASSPORT = "P";
    private static final String DOCUMENT_NUMBER = "10121314";

    public CustomerResponse findCustomerByTypeAndNumberDocument(String documentType, String documentNumber){

        log.info("Validando la data ingresada");
        validateData(documentType, documentNumber);
        CustomerResponse customer = loadData();
        return customer;

    }

    private void validateData(String documentType, String documentNumber){
        if (StringUtils.isBlank(documentType) && StringUtils.isBlank(documentNumber)) {
            throw new BadRequestException("El tipo y número de documento son obligatorios");
        } else {
            if (CITIZENSHIP_CARD.equals(documentType)) {
                if (!DOCUMENT_NUMBER.equals(documentNumber)) {
                    throw new NotFoundException("No se encontraron datos para el número de documento ingresado");
                }
            } else {
                throw new BadRequestException("No se encontraron datos para el tipo de documento ingresado");
            }
        }
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
