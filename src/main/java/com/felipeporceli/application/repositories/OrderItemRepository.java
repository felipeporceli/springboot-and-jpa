/* PT:BR Classe responsável por acessar dados/interagir com o banco de dados de solicitações ligadas a entidade "OrderItem" */
/* EN:US Class responsible for accessing data/interacting with the database for requests related to the "OrderItem" entity. */

package com.felipeporceli.application.repositories;

import com.felipeporceli.application.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
