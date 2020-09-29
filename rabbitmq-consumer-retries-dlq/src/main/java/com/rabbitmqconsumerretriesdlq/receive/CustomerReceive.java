package com.rabbitmqconsumerretriesdlq.receive;

import com.rabbitmqconsumerretriesdlq.dto.CustomerDTO;
import com.rabbitmqconsumerretriesdlq.source.CustomerSource;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableBinding(CustomerSource.class)
public class CustomerReceive {


    @StreamListener("customer-input")
    public void receive(@Payload final CustomerDTO customerDTO) {

        if (customerDTO.getId() != 0L) {

            System.out.println(customerDTO);

        } else {

            throw new RuntimeException("Erro! Mandar para Fila de Retries");

        }
    }
}
