package com.ecvlearning.javaee.mdb;

import com.ecvlearning.javaee.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @JmsListener(destination = "clearingHouse", containerFactory = "myFactory")
    @SendTo("cleared")
    public String receiveMessage(Trade trade) {
        logger.info("Receiver Ticker:" + trade.getTicker()+" Action:"+ trade.getAction());

        return "Ticker:" + trade.getTicker()+" Action:"+ trade.getAction();
    }

}
