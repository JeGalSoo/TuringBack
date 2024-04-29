package com.example.demo.common.security.service;

import com.example.demo.common.component.Messenger;
import com.example.demo.user.model.UserDto;

public interface AuthService {

    Messenger login(UserDto userDto);
    String createToken(UserDto user);
}

