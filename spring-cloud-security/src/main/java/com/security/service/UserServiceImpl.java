package com.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.security.feign.UserFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by KingsWong on 19/1/10.
 */
@Service
public class UserServiceImpl  implements UserDetailsService{

    @Autowired
    private UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String userInfo = userFeign.findUserByUserName(s);
        if(StringUtils.isBlank(userInfo)){
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin");
        JSONObject userJson = JSON.parseObject(userInfo);
        User user = new User(userJson.getString("userName"), userJson.getString("password"),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
