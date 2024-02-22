package com.mvcdemo.web.service;

import com.mvcdemo.web.dto.RegistrationDto;
import com.mvcdemo.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);


    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
