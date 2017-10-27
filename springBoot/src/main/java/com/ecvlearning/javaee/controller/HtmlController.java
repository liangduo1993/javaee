package com.ecvlearning.javaee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {
    Logger logger = LoggerFactory.getLogger(HtmlController.class);

    @RequestMapping(value = "/page")
    public ModelAndView toPage(){
        logger.info("Html controller to page:");
        ModelAndView mav = new ModelAndView("pages/page.html");
        return mav;
    }
}
