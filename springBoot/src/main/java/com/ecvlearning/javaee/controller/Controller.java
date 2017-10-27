package com.ecvlearning.javaee.controller;

import com.ecvlearning.javaee.Constants.ControllerConstants;
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

    @RequestMapping(value = "/loadTradesByPriceRange",  method = RequestMethod.GET)
    public @ResponseBody
    List<Trade> getAllTrades(@PathParam(value="low") String low, @PathParam(value="high") String high){
        logger.debug("Load trades by price range ");
        try {
            return this.tradeBo.getTradeByPrice(new Long(low),new Long(high));
        } catch (IOException e) {
            logger.error("GetTradesByPrice: ",e);
        }
        return null;
    }


    @RequestMapping(value = "/register",  method = RequestMethod.GET)
    public @ResponseBody
    boolean register(@RequestParam(value="input_username") String userName,
                             @RequestParam(value="input_pwd") String password,
                             @RequestParam(value="input_desc") String desc,
                     @RequestParam(value="sel_role", defaultValue = ControllerConstants.ROLE_USER) String role){
        logger.info("Register new user: " + userName);
        try {
            if(tradeBo.isUserExist(userName)){
                return false;
            }else {
                return tradeBo.createUser(userName, password, desc, role);
            }
        } catch (IOException e) {
            logger.error("Register new user: ",e);
        }
        return false;
    }

}
