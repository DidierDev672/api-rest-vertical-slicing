package com.example.features.User.application.service.DeleteUserUseCase;

import com.example.features.User.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeleteUserUseCase {
    @Inject
    UserRepository userRepository;

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
