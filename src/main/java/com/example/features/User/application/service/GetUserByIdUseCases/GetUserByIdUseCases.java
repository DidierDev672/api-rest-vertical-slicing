package com.example.features.User.application.service.GetUserByIdUseCases;

import com.example.features.User.domain.model.Users;
import com.example.features.User.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class GetUserByIdUseCases {
    @Inject
    UserRepository userRepository;

    @Transactional
    public Users getUserById(Long id){
        return userRepository.findById(id);
    }
}
