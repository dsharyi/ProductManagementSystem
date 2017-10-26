package com.product.project.controllers;

import com.product.project.entities.UserEntity;
import com.product.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by nonal on 17.10.2017.
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // localhost:8080/user/list
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserEntity> userEntityList = userService.getAll();
        modelAndView.addObject("userList", userEntityList);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        UserEntity userEntity = userService.getById(Integer.parseInt(id));
        userService.remove(userEntity);
        List<UserEntity> userEntityList = userService.getAll();
        modelAndView.addObject("userList", userEntityList);
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
