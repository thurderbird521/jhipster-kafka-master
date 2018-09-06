package com.mycompany.myapp.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {

    String CHANNEL = "subscribableChannel";
    
    String CHANNEL2 = "subscribableChannel2";

    @Input
    SubscribableChannel subscribableChannel();
    
    @Input
    SubscribableChannel subscribableChannel2();
}
