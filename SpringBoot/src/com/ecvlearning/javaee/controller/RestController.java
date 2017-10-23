package com.ecvlearning.javaee.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/firstRestExample/{msg}", method= RequestMethod.GET)
    public @ResponseBody String getMsg(@PathVariable String msg) {
        return msg;
    }

    @RequestMapping(value = "/firstRestExample/{msg}", method= RequestMethod.DELETE)
    public @ResponseBody String delMsg(@PathVariable String msg) {
        return "delete: "+msg;
    }
}
