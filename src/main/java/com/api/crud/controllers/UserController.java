package com.api.crud.controllers;

import com.api.crud.models.UserModels;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModels> getUsers(){
        return this.userService.getUser();
    }

    @PostMapping
    public UserModels saveUser(@RequestBody UserModels user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModels> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModels updateUserById(@RequestBody UserModels request,@PathVariable("id") Long id){
        return this.userService.updateById(request,id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteByid(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User with id "+id+ "deleted";
        }else {
            return "Error, we have a problem";
        }
    }
}
