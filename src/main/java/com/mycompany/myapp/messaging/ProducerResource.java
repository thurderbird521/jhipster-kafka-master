package com.mycompany.myapp.messaging;

import com.codahale.metrics.annotation.Timed;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerResource{

    private MessageChannel channel;
    private MessageChannel channel2;

    public ProducerResource(ProducerChannel channel) {
        this.channel = channel.messageChannel();
        this.channel2 =channel.messageChannel2();
    }

    @GetMapping("/greetings/{count}")
    @Timed
    public void produce(@PathVariable int count) {
        while(count > 0) {
            channel.send(MessageBuilder.withPayload(new Greeting().setMessage("Hello world!: " + count)).build());
            channel2.send(MessageBuilder.withPayload(new Greeting().setMessage("come on baby!: " + count)).build());
            count--;
        }
    }

}
