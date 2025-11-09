package com.felipeporceli.application.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.felipeporceli.application.entities.enums.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    // Order Atributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
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
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    @OneToOne(mappedBy = "order",
            cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {

    }

    public Order(Integer id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.orderStatus = orderStatus;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal () {
        double sum = 0.0;
        for (OrderItem x : items) {
            sum += x.getSubTotal();
        }
        return sum;
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
