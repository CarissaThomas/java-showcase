package com.example.camelmicroservice1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyFirstTimerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        System.out.println("Configuring Camel route.");

        from("timer:first-timer")
                .transform().constant("My constant")
                .log("timer event triggered")
                .to("log:first-timer");

/*        from("timer:java?period=2s")
                // refer to the route configuration by the id to use for this route
                .routeConfigurationId("javaError")
                .setBody(method(MyFirstTimerRouter.class, "randomNumber"))
                .log("Random number ${body}")
                .filter(simple("${body} < 30"))
                .throwException(new IllegalArgumentException("The number is too low"));*/
    }

    public static int randomNumber() {
        return new Random().nextInt(100);
    }
}

