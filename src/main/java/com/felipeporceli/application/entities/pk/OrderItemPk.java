package com.felipeporceli.application.entities.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipeporceli.application.entities.Order;
import com.felipeporceli.application.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;



/* When you create an ordering system, an Order can have multiple Products,
and a Product can be in multiple Orders. This is a Many-to-Many relationship.

However, in the context of an order, it's not enough to know that "Product X is in Order Y". You also need to store additional
information about the item in the order, such as the price paid and the quantity, and this information doesn't belong to the
Order or the Product.

For this, we use the `@Embeddable` annotation, which means "This class is not a standalone entity; it will be embedded within " +
another entity." */

@Embeddable
public class OrderItemPk {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPk that = (OrderItemPk) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }


}
