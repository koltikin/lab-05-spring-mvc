package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Product {
    private UUID id;
    private Integer remainingQuantity;
    private Integer quantity;
    private BigDecimal price;
    private String name;
}
