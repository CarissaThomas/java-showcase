package com.example.camelmicroservice1;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyTimerRouter extends RouteBuilder {

    @Autowired private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired private SimpleLoggingProcessingComponent loggingComponent;

    @Autowired private SimpleLoggingProcessor loggingProcessor;

    @Override
    public void configure() throws Exception {
        //Processing
        //Transformation
        //Database

        from("timer:first-timer")
                .log("${body}")
                .bean(getCurrentTimeBean)
                .log("${body}")
                .bean(loggingComponent)
                .process(new SimpleLoggingProcessor())
                .to("log:first-timer");
    }
}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime() {
        return "Time now is" + LocalDateTime.now();
    }
}

@Component
class SimpleLoggingProcessingComponent {
    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    public void process(String message) {
        logger.info("SimpleLoggingProcessingComponent {}", message);
    }
}

@Component
class SimpleLoggingProcessor implements org.apache.camel.Processor {
    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("SimpleLoggingProcessor {}", exchange);
    }
}