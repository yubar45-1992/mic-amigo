package com.shm.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemDto {
    private Long id;
    private String skuCode;
    private Integer quantity;
    private Long price;
}
