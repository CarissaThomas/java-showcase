package com.example.camelmicroservice2.routes;

import com.example.camelmicroservice2.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class ActiveMqXmlReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //JSON: serialize JSON message body to class
  /*      from("activemq:my-activemq-queue")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)// translated from JSON to class
                .to("log:received-messagge-from-active-xml-mq");*/
    }
}
