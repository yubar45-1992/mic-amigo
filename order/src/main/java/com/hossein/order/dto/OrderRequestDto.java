package com.hossein.order.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {

    private String orderNumber;
    private List<OrderLineItemDto> orderLineItemDtos;

}
