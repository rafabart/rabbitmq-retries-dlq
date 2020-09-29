package com.rabbitmqproducerretriesdlq.controller;

import com.rabbitmqproducerretriesdlq.dto.CustomerDTO;
import com.rabbitmqproducerretriesdlq.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendCostumer(@RequestBody final CustomerDTO customerDTO) {

        customerService.sendCustomer(customerDTO);
    }
}
