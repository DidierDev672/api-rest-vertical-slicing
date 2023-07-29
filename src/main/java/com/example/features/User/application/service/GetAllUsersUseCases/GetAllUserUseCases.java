package com.example.features.User.application.service.GetAllUsersUseCases;

import com.example.features.User.domain.model.Users;
import com.example.features.User.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllUserUseCases {
    @Inject
    UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.listAll();
    }
}
