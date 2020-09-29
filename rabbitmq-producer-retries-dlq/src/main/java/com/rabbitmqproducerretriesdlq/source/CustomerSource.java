package com.rabbitmqproducerretriesdlq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerSource {

    String CUSTOMER_OUTPUT = "customer-output";

    @Output(CUSTOMER_OUTPUT)
    MessageChannel sendMessage();
}
