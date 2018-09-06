package com.mycompany.myapp.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannel {

    String CHANNEL = "messageChannel";
    
    String CHANNEL2 = "messageChannel2";

    @Output
    MessageChannel messageChannel();
    
    @Output
    MessageChannel messageChannel2();
    
}
