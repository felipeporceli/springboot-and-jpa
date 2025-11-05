package com.felipeporceli.application.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;

    /* PT:BR Mapeando relacionamento "vários para um" com a entidade "User", pois o pedido só pode estar atrelado a um usuário.
    Para isso a anotation @ManyToOne. A anotation @JoinColumn é para mapearmos que o atributo client irá entrar na tabela do
    banco de dados como uma chave estrangeira de nome "client_id"*/
    /* EN:US Mapping a "many-to-one" relationship with the "User" entity, since an order can only be linked to one user.
    For this, the @ManyToOne annotation is used. The @JoinColumn annotation is to map that the "client" attribute will be included
    in the database table as a foreign key named "client_id". */

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {

    }

    public Order(Integer id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
