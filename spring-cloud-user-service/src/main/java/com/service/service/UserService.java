package com.service.service;

import com.service.entity.UserEntity;
import com.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KingsWong on 19/1/8.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    public UserEntity getUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }



    public UserEntity getUserById(Long id){
        return userRepository.findById(id).get();
    }


    public void delete(UserEntity userEntity){
        userRepository.delete(userEntity);
    }
}
