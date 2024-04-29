package com.example.demo.user.service;

import com.example.demo.common.component.Messenger;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UserService extends CommandService<User>, QueryService<UserDto> {
    List<?> findByName(String name);
    List<?> findByJob(String job);
    default User dtoToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .name(dto.getName())
                .phone(dto.getPhone())
                .job(dto.getJob())
//                .articles(dto.getArticles())
                .build();
    }

    default UserDto entityToDto(User ent) {
        return UserDto.builder()
                .id(ent.getId())
                .username(ent.getUsername())
                .password(ent.getPassword())
                .name(ent.getName())
                .phone(ent.getPhone())
                .job(ent.getJob())
                .build();
    }

    Messenger login(UserDto userDto);

    Messenger findByUsername(String username);

    Messenger existsByUsername(String username);

    Boolean logout(String accessToken);
}
