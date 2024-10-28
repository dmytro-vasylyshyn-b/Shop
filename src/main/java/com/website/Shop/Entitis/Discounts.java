package com.website.Shop.Entitis;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Discounts")
public class Discounts {

    @Id
    @Column(name = "discount_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long discountId;

    @Column(name = "discount_percentage")
    private byte discountPercentage;

    @Column(name = "discount_start_date")
    private Date discountStartDate;

    @Column(name = "discount_end_date")
    private Date discountEndDate;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL)
    private List<Products> products;
}
