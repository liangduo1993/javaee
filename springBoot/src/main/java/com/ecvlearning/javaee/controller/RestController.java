package com.ecvlearning.javaee.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/msg/{msg}", method= RequestMethod.GET)
    public @ResponseBody String getMsg(@PathVariable String msg) {
        return msg;
    }

    @RequestMapping(value = "/msg/{msg}", method= RequestMethod.DELETE)
    public @ResponseBody String delMsg(@PathVariable String msg) {
        System.out.println("delete msg:"+msg);
        return "delete: "+msg;
    }
}
