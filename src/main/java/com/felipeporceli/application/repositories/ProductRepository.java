/* PT:BR Classe responsável por acessar dados/interagir com o banco de dados de solicitações ligadas a entidade "User" */
/* EN:US Class responsible for accessing data/interacting with the database for requests related to the "User" entity. */

package com.felipeporceli.application.repositories;

import com.felipeporceli.application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
