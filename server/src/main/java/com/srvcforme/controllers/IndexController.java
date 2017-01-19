package com.srvcforme.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@org.springframework.stereotype.Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "    <title>Decmo</title>\n" +
                "    <meta name=\"description\" content=\"\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width\"/>\n" +
                "    <base href=\"/\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/webjars/bootstrap/css/bootstrap.min.css\"/>\n" +
                "    <script type=\"text/javascript\" src=\"/webjars/jquery/jquery.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"/webjars/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>Demo</h1>\n" +
                "\t<div class=\"container\"></div>\n" +
                "</body>\n" +
                "</html>";
    }
}
