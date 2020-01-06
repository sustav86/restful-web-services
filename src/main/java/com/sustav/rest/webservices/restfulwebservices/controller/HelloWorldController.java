package com.sustav.rest.webservices.restfulwebservices.controller;

import com.sustav.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World Microservices";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Microservices from Bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World Microservices from %s", name));
    }
}
