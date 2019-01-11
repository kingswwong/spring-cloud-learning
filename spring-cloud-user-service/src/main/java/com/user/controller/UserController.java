package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KingsWong on 19/1/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public User findUserByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @PostMapping
    public String saveUser(User user){
        String msg = "success";
        try {
            userService.saveUser(user);
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }
}
