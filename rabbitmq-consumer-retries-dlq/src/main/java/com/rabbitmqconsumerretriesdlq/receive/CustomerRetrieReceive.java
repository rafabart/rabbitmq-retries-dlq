package com.rabbitmqconsumerretriesdlq.receive;

import com.rabbitmqconsumerretriesdlq.dto.CustomerDTO;
import com.rabbitmqconsumerretriesdlq.source.CustomerRetrieSource;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@EnableBinding(CustomerRetrieSource.class)
public class CustomerRetrieReceive {

    @StreamListener("customer-retrie")
    public void receive(@Payload final CustomerDTO customerDTO,
                        @Headers final Map<?, ?> headers,
                        @Header("deliveryAttempt") final String attempt) {

        System.out.println(headers);

        if (customerDTO.getId() != 0L) {

            System.out.println(customerDTO);
        }

        if (Integer.parseInt(attempt) >= 3) {
            throw new IllegalStateException("Desistir! Mandar pra  DLQ");
        } else {
            throw new RuntimeException("Falhou. Retentar!");
        }
    }
}
