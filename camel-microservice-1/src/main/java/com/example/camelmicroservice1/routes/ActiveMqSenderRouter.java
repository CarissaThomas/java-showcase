package com.example.camelmicroservice1.routes;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // TIMER

/*        from("timer:active-mq?period=10000")
                .transform().constant("My message for Active MQ")
                .to("activemq:my-activemq-queue");*/

        // QUEUE: file is picked up and send to the queue
        from("file:file/json")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
