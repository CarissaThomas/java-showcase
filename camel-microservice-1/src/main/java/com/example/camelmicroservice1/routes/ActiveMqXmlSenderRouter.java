package com.example.camelmicroservice1.routes;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMqXmlSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/xml")
                .log("${body}")
                .to("activemq:my-activemq-xml-queue");
    }
}
