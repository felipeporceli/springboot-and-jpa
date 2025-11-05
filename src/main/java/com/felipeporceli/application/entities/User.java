/* PT:BR Classe dedicada á apresentar os atributos da entidade "User". Bem como mapear seus correspondentes no banco de dados.*/
/* EN:US Class dedicated to presenting the features of the "User" entity, as well as mapping its corresponding elements in
the database. */

package com.felipeporceli.application.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    //User atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, email, phone, password;

    /* PT:BR Mapeando relacionamento "um para vários" com a entidade "Order", pois um cliente pode realizar vários pedidos.
    Para isso a anotation @OneToMany. O atributo "orders" precisa ser uma lista, pois pode retornar diversos valores. */
    /* EN:US Mapping a "one-to-many" relationship with the "Order" entity, since one customer can place multiple orders. For this,
    the @OneToMany annotation is used. The "orders" attribute needs to be a list, as it can return multiple values.*/
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User () {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
