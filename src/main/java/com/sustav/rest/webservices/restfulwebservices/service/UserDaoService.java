package com.sustav.rest.webservices.restfulwebservices.service;

import com.sustav.rest.webservices.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Long userCount = 3L;
    static {
        users.add(new User(1L, "Adam", new Date()));
        users.add(new User(2L, "Eve", new Date()));
        users.add(new User(3L, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }


}
