package com.tjnu.park01.controller;

import com.tjnu.park01.domain.User;
import com.tjnu.park01.service.CarportService;
import com.tjnu.park01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Register {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/register")
    @ResponseBody
    public Object register(String username, String password){
        String status =userService.register(username, password);
        return status;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(String username, String password){
        String status=userService.login(username,password);
        return status;
    }
    /*
    @RequestMapping(value="/user")
    @ResponseBody
    public Object user(long id){
        User user= userService.queryUserById(id);
        return user;
    }
    */
}
