package com.jesus.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jesus.curso.springboot.error.springboot_error.Models.Domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    //constructor
    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Jesus", "Ortiz"));
        users.add(new User(2L, "Maria", "Arantza"));
        users.add(new User(3L, "Ana", "Linares"));
        users.add(new User(4L, "Carla", "Pontevedra"));
    }

    @Override
    public User findById(Long id) {

        User user = null;
        for (User u : users){ // for each de toda la vida
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
