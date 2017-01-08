package com.srvcforme.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api")
@RestController
public class BaseApi {

    @RequestMapping(value="/status", method= RequestMethod.GET)
    String statusRequest() {
        return "the server works";
    }
}
