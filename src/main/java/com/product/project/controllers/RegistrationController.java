package com.product.project.controllers;

import com.product.project.entities.UserEntity;
import com.product.project.entities.UserRoleEntity;
import com.product.project.services.UserRoleService;
import com.product.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@Controller
@RequestMapping(value = "/register", method = RequestMethod.POST)
public class RegistrationController {

    private UserService userService;
    private UserRoleService userRoleService;

    @Autowired
    public RegistrationController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public String register(@ModelAttribute("user")UserEntity userEntity){
        UserRoleEntity userRoleEntity = userRoleService.getById(1);
        HashSet<UserRoleEntity> userRoleEntitySet = new HashSet<>();
        userRoleEntitySet.add(userRoleEntity);
        userEntity.setUserRoleEntities(userRoleEntitySet);
        userService.save(userEntity);
        return "redirect:/login";
    }
}