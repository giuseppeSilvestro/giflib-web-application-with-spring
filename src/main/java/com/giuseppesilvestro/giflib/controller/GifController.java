package com.giuseppesilvestro.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GifController {
    //home page. As there is only value, you can omit it
    @RequestMapping(value = "/")
    public String listGifs() {
        //as the home.html file is in the right folder (resources/templates),
        // our framework will recognize it and display it
        return "home";
    }
}
