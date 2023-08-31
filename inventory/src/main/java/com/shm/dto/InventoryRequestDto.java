package com.shm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequestDto {
    private String skuCode;
    private Integer quantity;
}
