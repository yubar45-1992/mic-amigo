package com.shm.product.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDto {
    private String name;
    private String price;
    private String description;
}
