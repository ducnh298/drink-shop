package com.drinkshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordered_drink", schema = "public")
@Data
public class OrderedDrink {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private Drink drink;

    @OneToMany(mappedBy = "orderedDrink")
    private List<OrderedDrinkOption> orderedDrinkOptionList;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private EnumForEntity.DrinkSize drinkSize = EnumForEntity.DrinkSize.S;

    @Column
    private int quantity = 1;

    @Column
    private int percentIce = 100;

    @Column
    private int percentSugar = 100;
}
