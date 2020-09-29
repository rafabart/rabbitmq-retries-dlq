package com.rabbitmqproducerretriesdlq.service;

import com.rabbitmqproducerretriesdlq.dto.CustomerDTO;
import com.rabbitmqproducerretriesdlq.send.CustomerSend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerSend customerSend;


    public void sendCustomer(final CustomerDTO customerDTO) {
        customerSend.send(customerDTO);
    }
}
