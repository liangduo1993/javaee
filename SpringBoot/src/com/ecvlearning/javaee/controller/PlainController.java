package com.ecvlearning.javaee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlainController {
    Logger logger = LoggerFactory.getLogger(PlainController.class);
    @RequestMapping(value = "/goto/{path}")
    public ModelAndView goTo(@PathVariable String path){
        logger.info("Plain controller goto:"+path);
        ModelAndView mav = new ModelAndView(path);
        return mav;
    }

    @RequestMapping(value = "/page")
    public ModelAndView mav(){
        logger.info("Plain controller page:");
        ModelAndView mav = new ModelAndView("pages/page.html");
        return mav;
    }
}
