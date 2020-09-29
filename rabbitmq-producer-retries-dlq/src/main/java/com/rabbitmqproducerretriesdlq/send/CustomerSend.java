package com.rabbitmqproducerretriesdlq.send;

import com.rabbitmqproducerretriesdlq.dto.CustomerDTO;
import com.rabbitmqproducerretriesdlq.source.CustomerSource;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableBinding(CustomerSource.class)
public class CustomerSend {

    private final CustomerSource customerSource;

    public void send(final CustomerDTO customerDTO) {

        //Define a mensagem do tipo CustomerDTO, e insere o objeto customerDTO no payload da mensagem
        final Message<CustomerDTO> message = MessageBuilder.withPayload(customerDTO).build();

        customerSource.sendMessage().send(message);
    }
}
