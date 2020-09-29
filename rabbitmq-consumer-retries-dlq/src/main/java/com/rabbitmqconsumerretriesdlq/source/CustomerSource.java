package com.rabbitmqconsumerretriesdlq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomerSource {

    @Input("customer-input")
    SubscribableChannel receiveMessage();
}
