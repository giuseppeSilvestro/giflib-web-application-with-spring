package com.giuseppesilvestro.giflib.controller;

import com.giuseppesilvestro.giflib.data.GifRepository;
import com.giuseppesilvestro.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class GifController {
    /*
    Spring has a function that can initialize fields for us when we need them in the code, but there is a condition:
    it needs to find a component of the same class for the field.
    To use this function we have the @Autowired.
    To tell Spring where to look for the component we use the @Component annotation
    (in this case, in the GifRepository class).
    This process of assigning objects without explicitly writing any code is called: Dependency Injection, or DI.
     */
    @Autowired
    private GifRepository gifRepository;

    //home page. As there is only value, you can omit it
    @RequestMapping(value = "/")
    public String listGifs() {
        //as the home.html file is in the right folder (resources/templates),
        // our framework will recognize it and display it
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        Gif gif = gifRepository.findByName("android-explosion");
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
