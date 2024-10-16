package com.meli.interview.back.subscription_api.controllers;

import com.meli.interview.back.subscription_api.domain.models.User;
import com.meli.interview.back.subscription_api.dtos.CreateUserDTO;
import com.meli.interview.back.subscription_api.dtos.UserDTO;
import com.meli.interview.back.subscription_api.infrastructure.daos.userDAO.UserDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {

        User user = userDAO.create(createUserDTO.getName());

        UserDTO userDTO = new UserDTO(user.getId(), user.getName());

        return ResponseEntity.ok(userDTO);
    }

}