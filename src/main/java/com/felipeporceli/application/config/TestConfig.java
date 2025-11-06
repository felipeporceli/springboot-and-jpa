/* PT:BR Classe utilizada para fazer algumas alterações na aplicação Spring. No caso, ela estará povoando o banco de dados com
alguns dados no momento do inicio da aplicação utilizando o "UserRepository".*/

/* EN:US This class is used to make some changes to the Spring application. In this case, it will populate the database with
some data when the application starts using the "UserRepository".*/

package com.felipeporceli.application.config;

import com.felipeporceli.application.entities.Category;
import com.felipeporceli.application.entities.Order;
import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.entities.enums.OrderStatus;
import com.felipeporceli.application.repositories.CategoryRepository;
import com.felipeporceli.application.repositories.OrderRepository;
import com.felipeporceli.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Stetic");
        Category c3 = new Category(null, "Clothies");

        repository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

    }
}
