/* PT-BR Classe para manipular e lidar com requisições web relacionadas a entidade "User" */
/* EN:US Class for manipulating and handling web requests related to the "User" entity. */
package com.felipeporceli.application.controller;

import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    /* PT:BR Metodo para consultar usuário por id no corpo do caminho da URL*/
    /* EN:US Method for querying a user by ID.*/
    @GetMapping (value = "{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User obj = service.findUserById(id);
        return ResponseEntity.ok().body(obj);
    }

    /* PT:BR Metodo para inserir usuário passando os parâmetros no corpo de requisicao */
    /* EN:US Method for inserting a user by passing the parameters in the request body. */
    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User obj) {
        obj = service.insertUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    /* PT:BR Metodo para deletar um usuário por id no corpo do caminho da URL */
    /* EN:US Method for deleting a user by ID in the URL path body. */
    @DeleteMapping (value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /* PT:BR Metodo para atualizar um usuário por id no corpo do caminho da URL e parâmetros no corpo da requisição */
    /* EN:US Method for updating a user by ID in the URL path and parameters in the request body. */
    @PutMapping (value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User obj) {
        obj = service.updateUser(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
