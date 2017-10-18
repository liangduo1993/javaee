package com.ecvlearning.javaee.controller;

import com.ecvlearning.javaee.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);
    Trade trade = new Trade();
    public Controller(){
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

    @RequestMapping(value = "/listStockByTicker",  method = RequestMethod.GET)
    public @ResponseBody Trade getListing(@RequestParam(value = "ticker", required = false) String ticker){
        logger.info("Load stock listing "+ticker);

        if(this.trade.getTicker().equals(ticker)){
            return this.trade;
        }else{
            return null;
        }
    }
}
