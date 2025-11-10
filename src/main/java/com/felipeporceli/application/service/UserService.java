package com.felipeporceli.application.service;

import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.entities.exceptions.ResourceNotFoundException;
import com.felipeporceli.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    /* PT:BR Metodo para consultar usuário por id */
    /* EN:US Method to query user by id */
    public User findUserById (Long id) {
        Optional<User> user = repository.findById(id);
        return  user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /* PT:BR Metodo para inserir usuário passando os parâmetros no corpo de requisicao */
    /* EN:US Method to insert a user by passing the parameters in the request body */
    public User insertUser (User user) {
        return repository.save(user);
    }

    /* PT:BR Metodo para deletar um usuário por id no corpo do caminho da URL */
    public void deleteUser (Long id) {
        repository.deleteById(id);
    }

    /* PT:BR Metodo para atualizar um usuário por id no corpo do caminho da URL e parâmetros no corpo da requisição */
    /* EN:US Method to delete a user by ID in the URL path */
    public User updateUser (Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
