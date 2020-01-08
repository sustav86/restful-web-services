package com.sustav.rest.webservices.restfulwebservices.controller;

import com.sustav.rest.webservices.restfulwebservices.entity.User;
import com.sustav.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.sustav.rest.webservices.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> save(@RequestBody User user) {
        User newUser = userDaoService.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteByid(@PathVariable Long id) {
        if (!userDaoService.deleteById(id)) {
            throw new UserNotFoundException("id - " + id);
        }
    }
}
