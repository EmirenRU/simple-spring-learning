package com.mvcdemo.web.service.impl;

import com.mvcdemo.web.dto.RegistrationDto;
import com.mvcdemo.web.models.Role;
import com.mvcdemo.web.models.UserEntity;
import com.mvcdemo.web.repository.RoleRepository;
import com.mvcdemo.web.repository.UserRepository;
import com.mvcdemo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;


public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }


}
