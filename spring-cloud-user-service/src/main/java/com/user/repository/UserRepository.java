package com.user.repository;

import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KingsWong on 19/1/10.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
