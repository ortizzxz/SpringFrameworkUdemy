package com.jesus.curso.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jesus.curso.springboot.app.springboot_crud.entities.Role;
import com.jesus.curso.springboot.app.springboot_crud.entities.User;
import com.jesus.curso.springboot.app.springboot_crud.repositories.RoleRepository;
import com.jesus.curso.springboot.app.springboot_crud.repositories.UserRepository;


@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;    

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(r -> roles.add(r));
        // optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            
            optionalRoleAdmin.ifPresent(r -> roles.add(r));
        }

        user.setRoles(roles);

        // password encoder 
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        
        user.setPassword(passwordEncoded);

        return repository.save(user);
    }

}
