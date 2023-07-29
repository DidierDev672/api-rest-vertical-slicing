package com.example.features.User.domain.repository;
import com.example.features.User.domain.model.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<Users>{
    public Users findByUsername(String username){
        return find("name", username).firstResult();
    }

    public Users findByEmail(String email){
        return find("email", email).firstResult();
    }

//    public Users findById(Long id){
//        return find("id", id).firstResult();
//    }
}
