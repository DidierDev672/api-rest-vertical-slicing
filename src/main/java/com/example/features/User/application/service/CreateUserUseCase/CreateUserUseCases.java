package com.example.features.User.application.service.CreateUserUseCase;

import com.example.features.User.domain.model.Users;
import com.example.features.User.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CreateUserUseCases {
    @Inject
    UserRepository userRepository;

    @Transactional
    public void createUser(String name, String email, String password){
        Users users = new Users();
        users.setName(name);
        users.setEmail(email);
        users.setPassword(password);
        userRepository.persist(users);
    }
}
