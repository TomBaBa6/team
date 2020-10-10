package com.etc.controller;

import com.etc.entity.User;
import com.etc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/getUser/{id}")
    public User getUserByid(@PathVariable("id")Integer id){
        User u=userService.getUserById(id);
        return u;
    }


}
