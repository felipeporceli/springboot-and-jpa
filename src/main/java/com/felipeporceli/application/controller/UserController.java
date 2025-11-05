/* PT-BR Classe para manipular e lidar com requisições web relacionadas a entidade "User" */
/* EN:US Class for manipulating and handling web requests related to the "User" entity. */
package com.felipeporceli.application.controller;

import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAllUsers();
        return ResponseEntity.ok().body(users);
    }
}
