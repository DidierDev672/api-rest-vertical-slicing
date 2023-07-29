package com.example.features.User.infrastructure.rest;

import com.example.features.User.domain.model.Users;
import com.example.features.User.application.service.CreateUserUseCase.CreateUserUseCases;
import com.example.features.User.application.service.DeleteUserUseCase.DeleteUserUseCase;
import com.example.features.User.application.service.GetAllUsersUseCases.GetAllUserUseCases;
import com.example.features.User.application.service.GetUserByIdUseCases.GetUserByIdUseCases;
import com.example.features.User.application.service.UpdateUserUseCases.UpdateUserUseCases;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private final  CreateUserUseCases createUserUseCases;
    private final GetAllUserUseCases getAllUserUseCases;
    private final GetUserByIdUseCases getUserByIdUseCases;
    private final UpdateUserUseCases updateUserUseCases;
    private final DeleteUserUseCase deleteUserUseCase;
    @Inject
    public UserController(CreateUserUseCases createUserUseCases, GetAllUserUseCases getAllUserUseCases, GetUserByIdUseCases getUserByIdUseCases, UpdateUserUseCases updateUserUseCases, DeleteUserUseCase deleteUserUseCase){
        this.createUserUseCases = createUserUseCases;
        this.getAllUserUseCases = getAllUserUseCases;
        this.getUserByIdUseCases = getUserByIdUseCases;
        this.updateUserUseCases = updateUserUseCases;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @GET
    public List<Users> getAllUser(){
        return getAllUserUseCases.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public Users getUserById(@PathParam("id") Long id){
        return getUserByIdUseCases.getUserById(id);
    }

    @POST
    public void createUser(Users user){
        createUserUseCases.createUser(user.getName(), user.getEmail(), user.getPassword());
    }

    @PUT
    @Path("/{id}")
    public void updateUser(@PathParam("id") Long id, Users updatedUser){
        Users user = getUserByIdUseCases.getUserById(id);
        if(user != null){
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            updateUserUseCases.updateUser(user);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id){
        deleteUserUseCase.deleteUser(id);
    }
}
