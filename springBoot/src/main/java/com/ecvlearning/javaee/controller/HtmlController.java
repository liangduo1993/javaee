package com.ecvlearning.javaee.controller;


import com.ecvlearning.javaee.dao.UserRepo;
import com.ecvlearning.javaee.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HtmlController {
    Logger logger = LoggerFactory.getLogger(HtmlController.class);

    @Autowired
    UserRepo userRepo;

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
}
