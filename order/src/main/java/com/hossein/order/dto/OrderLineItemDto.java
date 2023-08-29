package com.hossein.order.dto;

import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

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
