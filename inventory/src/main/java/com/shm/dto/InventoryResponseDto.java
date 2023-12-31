package com.shm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseDto {
    private String skuCode;
    private Boolean isInStock;
}
