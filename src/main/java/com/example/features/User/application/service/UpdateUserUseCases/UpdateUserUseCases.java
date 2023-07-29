package com.example.features.User.application.service.UpdateUserUseCases;


import com.example.features.User.domain.model.Users;
import com.example.features.User.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UpdateUserUseCases {
    @Inject
    UserRepository userRepository;

    @Transactional
    public void updateUser(Users updatedUser){
        Users users = userRepository.findById(updatedUser.getId());
        if(users != null){
            users.setEmail(updatedUser.getEmail());
            users.setName(updatedUser.getName());
            userRepository.persist(users);
        }
    }
}
