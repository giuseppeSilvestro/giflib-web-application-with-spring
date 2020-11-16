package com.giuseppesilvestro.giflib.controller;

import com.giuseppesilvestro.giflib.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class GifController {
    //home page. As there is only value, you can omit it
    @RequestMapping(value = "/")
    public String listGifs() {
        //as the home.html file is in the right folder (resources/templates),
        // our framework will recognize it and display it
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        Gif gif = new Gif("android-explosion",
                LocalDate.of(2015, 2, 13), "Giuseppe", true);
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
