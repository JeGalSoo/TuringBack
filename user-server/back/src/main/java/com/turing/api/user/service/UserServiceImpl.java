package com.turing.api.user.service;

import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.security.JwtProvider;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final JwtProvider jwtProvider;
    private final UserRepository repository;


    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        var dto = Optional.ofNullable(entityToDto(Objects.requireNonNull(repository.findById(id).orElse(null))));
        return dto;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Messenger save(User user) {
        if(existsById(user.getId()))repository.save(user);
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
         if(repository.existsById(id)){
             repository.deleteById(id);
            return Messenger.builder()
                    .message("SUCCESS")
                    .build();
        }else {
             return Messenger.builder()
                     .message("FAIL")
                     .build();
         }
    }

    @Override
    public Messenger modify(User user) {
        return Messenger.builder()
                .message(repository.save(user).toString())
                .build();
    }

    @Override
    public List<?> findByName(String name) {
        var dto = new ArrayList<>();
//        dto.add(re.findByUsername(name));
        return dto;
    }

    @Override
    public List<?> findByJob(String job) {
        var dto = new ArrayList<>();
        dto.add(repository.findUsersByJob(job));
        return dto;
    }

    @Transactional
    @Override
    public Messenger login(UserDto userDto) {
        var user = repository.findByUsername(userDto.getUsername());
        log.info(user.getPassword());
        log.info(userDto.getPassword());
        var token = jwtProvider.createToken(entityToDto(user));
        var flag = user.getPassword().equals(userDto.getPassword());
        log.info(String.valueOf(flag));
        repository.modifyTokenById(token,user.getId());
        jwtProvider.printPayload(token);

        return Messenger.builder()
                .message(flag? "SUCCESS":"FAIL")
                .accessToken(flag?token:"None")
                .build();
//        User user = re.findByUsername(userDto.getUsername());
//        if(userDto.getPassword().equals(user.getPassword())){
//            return Messenger.builder().message("SUCCESS").build();
//        }else{
//            return Messenger.builder().message("FAIL").build();
//        }
    }



    @Override
    public Messenger findByUsername(String username) {
        return null;
    }

    @Override
    public Messenger existsByUsername(String username) {
        log.info(username);
        return Messenger.builder()
                .message(repository.existsByUsername(username)?"true":"false")
                .build();
    }

    @Transactional
    @Override
    public Boolean logout(String accessToken) {
        log.info(accessToken);
        String data = jwtProvider.getId(accessToken);
        System.out.println(data);
        Long id = Long.valueOf(data);
        String deletedToken = null;
        repository.modifyTokenById(deletedToken,id);
        return findById(id).get().getToken() == null;
    }
}