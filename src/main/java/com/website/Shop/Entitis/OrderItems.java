package com.website.Shop.Entitis;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderItems")
public class OrderItems {

    @Id
    @Column(name = "order_items_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemsId;

    @Column(name = "quantity")
    private int quantity;


    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;
}
