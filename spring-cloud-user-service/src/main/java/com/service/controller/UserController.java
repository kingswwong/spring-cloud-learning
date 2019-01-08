package com.service.controller;

import com.service.entity.UserEntity;
import com.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KingsWong on 19/1/8.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        return "userIndex";
    }

    @GetMapping(value = "/{userName}")
    public UserEntity getByUserName(@PathVariable("userName")String userName){
        return userService.getUserByUserName(userName);
    }

    @PostMapping
    public String saveUser(UserEntity userEntity){
        String msg = "success";
        try{
            userService.save(userEntity);
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @PutMapping
    public String updateUser(UserEntity userEntity){
        String msg = "success";
        try{
            userService.save(userEntity);
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id")Long id){
        String msg = "success";
        try{
            userService.delete(userService.getUserById(id));
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }
}
