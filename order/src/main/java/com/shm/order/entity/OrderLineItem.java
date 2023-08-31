package com.shm.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "order_line_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Long price;
    private Integer quantity;


}
