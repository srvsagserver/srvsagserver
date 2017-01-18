package com.srvcforme.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@org.springframework.stereotype.Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "this is <b>index page</b>";
    }
}
