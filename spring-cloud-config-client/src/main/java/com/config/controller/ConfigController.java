package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KingsWong on 19/1/8.
 */
@RestController
public class ConfigController {
    @Value("${server.mysql.url}")
    private String mysqlUrl;

    @RequestMapping(value = "/getUrl")
    public String getMysqlUrl(){
        return this.mysqlUrl;
    }
}
