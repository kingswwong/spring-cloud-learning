package com.security.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by KingsWong on 19/1/10.
 */
@FeignClient(name= "spring-cloud-user-client")
public interface UserFeign {

    @RequestMapping(value = "/user/{userName}")
    public String findUserByUserName(@RequestParam("userName")String userName);
}
