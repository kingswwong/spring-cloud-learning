package com.user.service;

import com.user.entity.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KingsWong on 19/1/10.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
