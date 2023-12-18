package com.example.camelmicroservice2.routes;

import com.example.camelmicroservice2.CurrencyExchange;
import com.example.camelmicroservice2.processors.MyCurrencyExchangeProccesor;
import com.example.camelmicroservice2.transformers.MyCurrencyExchangeTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqJsonReceiverRouter extends RouteBuilder {


    @Autowired
    private MyCurrencyExchangeProccesor myCurrencyExchangeProccesor;

    @Autowired
    private MyCurrencyExchangeTransformer myCurrencyExchangeTransformer;

    @Override
    public void configure() throws Exception {
        //JSON: serialize JSON message body to class
  /*      from("activemq:my-activemq-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class) // translated from JSON to class
                .bean(myCurrencyExchangeProccesor)// complex business logic
                .bean(myCurrencyExchangeTransformer)// transform between data formats
                .to("log:received-messagge-from-active-mq");*/

    }
}

