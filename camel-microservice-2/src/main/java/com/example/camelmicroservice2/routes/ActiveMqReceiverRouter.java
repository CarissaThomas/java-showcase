package com.example.camelmicroservice2.routes;

import com.example.camelmicroservice2.CamelMicroservice2Application;
import com.example.camelmicroservice2.CurrencyExchange;
import com.example.camelmicroservice2.processors.MyCurrencyExchangeProccesor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {


    @Autowired
    private MyCurrencyExchangeProccesor myCurrencyExchangeProccesor;

    @Override
    public void configure() throws Exception {
        //JSON: serialize JSON message body to class
        from("activemq:my-activemq-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(myCurrencyExchangeProccesor)// translated to a bean
                .to("log:received-messagge-from-active-mq");

    }
}

