package com.punkrig.agregadordeinvestimentos.service;

import com.punkrig.agregadordeinvestimentos.controller.CreateUserDto;
import com.punkrig.agregadordeinvestimentos.entity.User;
import com.punkrig.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto){
        //DTO -> ENTITY
        var entity=new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null
        );
        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

}
