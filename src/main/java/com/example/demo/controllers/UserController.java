package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDTO;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    public UserService userService;

    // @GetMapping
    // public List<UserDTO> findAllUser() {
    // List<User> result = userService.findAll();
    // return result;
    // }

    @GetMapping
    public List<UserDTO> findAllUser() {
        return userService.findAllUser();
    }
}
