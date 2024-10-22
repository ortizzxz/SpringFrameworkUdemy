package com.jesus.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.curso.springboot.error.springboot_error.Models.Domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users;

    @Override
    public Optional<User> findById(Long id) {

        Optional<User> user = users.stream().filter(usr -> usr.getId().equals(id)).findFirst();

        // for (User u : users){ // for each de toda la vida
        //     if(u.getId().equals(id)){
        //          user = u;
        //         break;
        //     }
        // }
        
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
