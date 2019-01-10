package com.auth.controller;

import com.auth.entity.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KingsWong on 19/1/10.
 */
@RestController
public class PersonInfoController {

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody
    Person personInfo() {
        return new Person("peter", "Beijing", "China", 29, "Male");
    }
}