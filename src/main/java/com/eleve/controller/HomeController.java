package com.eleve.controller;

import com.eleve.services.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by arif on 11/10/16.
 */
@Controller(value = "/home")
public class HomeController {
    @RequestMapping(value = "/")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("test");
        return view;
    }


    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam String query) {
        ArrayList<String> tweetList = UtilityService.getHashtags(query);
        System.out.print("Tweet List Size ....."+ tweetList.size());
        ModelAndView view = new ModelAndView("test");
        view.addObject("tweetName",query);
        view.addObject("tweetList",tweetList);
        return view;
    }
}
