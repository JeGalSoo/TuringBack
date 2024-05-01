package com.turing.api.common.security.service;

import com.example.demo.user.model.UserDto;
import com.turing.api.common.component.Messenger;

public interface AuthService {

    Messenger login(UserDto userDto);
    String createToken(UserDto user);
}

