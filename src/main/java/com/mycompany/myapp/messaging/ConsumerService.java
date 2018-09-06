package com.mycompany.myapp.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);


    @StreamListener(ConsumerChannel.CHANNEL)
    public void consume(Greeting greeting) {
        log.info("Received message: {}.", greeting.getMessage());
    }
    
    @StreamListener(ConsumerChannel.CHANNEL2)
    public void consume2(Greeting greeting) {
        log.info("Baby message: {}.", greeting.getMessage());
    }
}
