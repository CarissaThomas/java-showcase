package com.example.camelmicroservice2.transformers;

import com.example.camelmicroservice2.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;



// Focuses specifically on converting the message body from one format to another. It's typically used for simpler
// and more straightforward data transformations, like converting message content between different data formats.
@Component
public class MyCurrencyExchangeTransformer {
    Logger logger = LoggerFactory.getLogger(com.example.camelmicroservice2.processors.MyCurrencyExchangeProccesor.class);
    public CurrencyExchange processMessage(CurrencyExchange currencyExchange) {
        currencyExchange.setConversionMultiple(
                currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));

        return currencyExchange;
    }
}