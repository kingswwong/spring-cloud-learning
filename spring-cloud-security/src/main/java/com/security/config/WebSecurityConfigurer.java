package com.security.config;

import com.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by KingsWong on 19/1/10.
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login**").permitAll().anyRequest().authenticated().and().csrf().and()
                .formLogin().loginPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
//                .password("admin").roles("USER", "ADMIN");

        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userService;
    }

}
