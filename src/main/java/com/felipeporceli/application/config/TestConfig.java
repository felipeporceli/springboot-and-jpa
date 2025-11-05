/* PT:BR Classe utilizada para fazer algumas alterações na aplicação Spring. No caso, ela estará povoando o banco de dados com
alguns dados no momento do inicio da aplicação utilizando o "UserRepository".*/

/* EN:US This class is used to make some changes to the Spring application. In this case, it will populate the database with
some data when the application starts using the "UserRepository".*/

package com.felipeporceli.application.config;

import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        repository.saveAll(Arrays.asList(u1,u2));

    }
}
