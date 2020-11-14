package com.giuseppesilvestro.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {
    //home page. As there is only value, you can omit it
    @RequestMapping(value = "/")
    @ResponseBody
    public String listGifs() {
        return "List of all the GIFs!";
    }
}
