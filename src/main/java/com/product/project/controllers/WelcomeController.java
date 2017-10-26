package com.product.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nonal on 17.10.2017.
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(){
        return "startpage";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout() {
        return "redirect:/login?logout";
    }

}