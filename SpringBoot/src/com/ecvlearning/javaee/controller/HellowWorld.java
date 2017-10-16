package com.ecvlearning.javaee.controller;

import com.ecvlearning.javaee.Boot;
import com.ecvlearning.javaee.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellowWorld {

    Logger logger = LoggerFactory.getLogger(HellowWorld.class);
    Trade trade = new Trade();
    public HellowWorld(){
        trade.setId(1);
        trade.setPrice(1000);
        trade.setTicker("AAPL");
    }

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld(){
        logger.info("hello world!");
        return "hello_world";
    }

    @RequestMapping(value = "/findTradeById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Trade retrieveTrade(@PathVariable String id){
        logger.info("retrieve trade by id:"+id);
        if(this.trade.getId() == Integer.valueOf(id)) {
            return this.trade;
        }else{
            return null;
        }
    }
}
