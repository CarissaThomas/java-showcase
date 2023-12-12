package com.example.camelmicroservice2.processors;

import com.example.camelmicroservice2.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//alter the message, exchange properties, handle exceptions, and more. It provides complete control over the message
//processing and is suitable for implementing complex logic.
@Component
public class MyCurrencyExchangeProccesor {
    Logger logger = LoggerFactory.getLogger(MyCurrencyExchangeProccesor.class);
    public void processMessage(CurrencyExchange currencyExchange) {
            logger.info("Do some processing", currencyExchange.getConversionMultiple());
    }
}
