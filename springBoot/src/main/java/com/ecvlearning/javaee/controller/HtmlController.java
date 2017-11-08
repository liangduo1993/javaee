package com.ecvlearning.javaee.controller;


import com.ecvlearning.javaee.dao.UserRepo;
import com.ecvlearning.javaee.model.Trade;
import com.ecvlearning.javaee.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HtmlController {
    Logger logger = LoggerFactory.getLogger(HtmlController.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = "/page")
    public ModelAndView toPage(){
        logger.info("Html controller to page:");
        ModelAndView mav = new ModelAndView("pages/page.html");
        return mav;
    }


    @RequestMapping(value = "/userLt")
    public @ResponseBody List<User> getUserLt(){
        logger.info("Html controller userLt:");
        List<User> list = this.userRepo.findAll();
        return list;
    }

    @RequestMapping(value = "/sendMsg/{ticker}")
    public @ResponseBody String sendMsg(@PathVariable String ticker){
        logger.info("Send to jms:"+ticker);

        Trade trade =new Trade();
        trade.setAction("Buy");
        trade.setClientName("JP Morgan");
        trade.setTicker(ticker);

        jmsTemplate.convertAndSend("clearingHouse", trade);

        String received = jmsTemplate.receiveAndConvert("cleared").toString();
        logger.info("Returned msg:"+received);

        return received;
    }

}
