package com.hossein.order.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long id;
    private String orderNumber;
    private List<OrderLineItemDto> orderLineItemDtos;

}
