package com.felipeporceli.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "tb_product")
public class Product {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name, description, imgUrl;
    private Double price;

   /* In our business model, we can see that the "Category" entity has a Many-to-Many relationship with the "Product" entity.
   This means that we will need to use Join Tables.
   When we talk about relational databases, a many-to-many relationship means:
   One record A can relate to several records B
   and one record B can relate to several records A.
   For example:
   - A Student can be in several Classes,
   - and a Class can have several Students.
   The database cannot directly represent a Many-to-Many relationship between two tables using only foreign keys in the records themselves.
   It needs a third table to store the combinations of relationships.

   This extra table is called a Join Table
   or associative table */
    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))

    /* Here we are saying, "Spring, this dataset has a Many-to-Many relationship with another Many-to-Many entity, therefore,
    create a JoinTable called "tb_product_category" where the foreign key of the owning class of the relationship will be
    called "product_id", and the foreign key of the other class will be called "category_id". */

    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {

    }

    public Product(Integer id, String name, String description, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
           set.add(x.getOrder());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
