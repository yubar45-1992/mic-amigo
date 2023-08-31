package com.shm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;


}
