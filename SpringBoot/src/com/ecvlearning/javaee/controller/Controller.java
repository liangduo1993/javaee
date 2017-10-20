package com.ecvlearning.javaee.controller;

import com.ecvlearning.javaee.business.TradeBo;
import com.ecvlearning.javaee.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    TradeBo tradeBo;

    @RequestMapping(value = "/loadAllTrades",  method = RequestMethod.GET)
    public @ResponseBody
    List<Trade> getAllTrades(){
        logger.info("Load all trading list ");
        try {
            return this.tradeBo.getTradeList();
        } catch (IOException e) {
            logger.error("GetAllTrades: ",e);
        }
        return null;
    }

    @RequestMapping(value = "/loadTradesByPrice",  method = RequestMethod.GET)
    public @ResponseBody
    List<Trade> getAllTrades(@PathParam(value="low") String low, @PathParam(value="high") String high){
        logger.info("Load all trading list ");
        try {
            return this.tradeBo.getTradeByPrice(new Long(low),new Long(high));
        } catch (IOException e) {
            logger.error("GetTradesByPrice: ",e);
        }
        return null;
    }

}
