package com.api.crud.services;

import com.api.crud.models.UserModels;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModels> getUser(){
        return (ArrayList<UserModels>) userRepository.findAll();
    }

    public UserModels saveUser(UserModels user){
        return userRepository.save(user);
    }

    public Optional<UserModels> getById(Long id){
        return userRepository.findById(id);

    }

    public UserModels updateById(UserModels request,Long id){
        UserModels  user =userRepository.findById(id).get();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());

        return user;

    }

    public Boolean deleteUser (Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

