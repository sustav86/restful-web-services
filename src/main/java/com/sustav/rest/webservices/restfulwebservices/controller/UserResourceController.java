package com.sustav.rest.webservices.restfulwebservices.controller;

import com.sustav.rest.webservices.restfulwebservices.entity.User;
import com.sustav.rest.webservices.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourceController {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> findAll() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User findOne(@PathVariable Long id) {
        return userDaoService.findOne(id);
    }

    @PostMapping(path = "/users")
    public User save(@RequestBody User user) {
        return userDaoService.save(user);
    }
}
