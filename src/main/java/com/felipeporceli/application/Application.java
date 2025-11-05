/* PT:BR A Classe "Application" é responsável pela inicialização da aplicação do Spring Boot em si. Ao iniciar, ela irá aplicar
todas as configurações que estão configurados dentro do nosso arquivo "application.properties". Atualmente sendo:
    - Banco de dados em memória "H2"
    - Configuração da base de dados
    - JPA
    - Configurações do dialeto do "H2" para o JPA*/

/* EN: The "Application" class is responsible for initializing the Spring Boot application itself. Upon startup, it will apply
all the configurations that are configured within our "application.properties" file. Currently including:
- In-memory database "H2"
- Database configuration
- JPA
- H2 dialect configurations for JPA*/

package com.felipeporceli.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
