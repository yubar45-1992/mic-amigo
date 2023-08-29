package com.hossein.order.service;

import com.hossein.order.dto.InventoryResponseDto;
import com.hossein.order.dto.OrderLineItemDto;
import com.hossein.order.dto.OrderRequestDto;
import com.hossein.order.entity.Order;
import com.hossein.order.entity.OrderLineItem;
import com.hossein.order.repository.OrderLineItemRepository;
import com.hossein.order.repository.OrderRepository;
import com.hossein.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Transactional
    public void save(OrderRequestDto orderRequest) {
        List<String> skuCodes = orderRequest.getOrderLineItemDtos().stream()
                .map(OrderLineItemDto::getSkuCode)
                .toList();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://inventory-service/api/v1/inventory-service")
                .queryParam("skuCodes", skuCodes);
        URI uri = builder.build().encode().toUri();
        InventoryResponseDto[] inventoryResponseDtos =restTemplate.getForObject(uri, InventoryResponseDto[].class);

       if (inventoryResponseDtos == null){
           throw new IllegalArgumentException("item is not exist");
       }
        boolean allProductInStock = Arrays.stream(inventoryResponseDtos).allMatch(InventoryResponseDto::getIsInStock);
        if (allProductInStock) {
            orderRepository.save(changeOrderDtoToEntity(orderRequest));

        } else throw new IllegalArgumentException("product is not in stock");


    }

    public List<OrderResponseDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders
                .stream()
                .map(this::changeEntityToDto)
                .toList();
    }

    private Order changeOrderDtoToEntity(OrderRequestDto orderRequest) {
        Order order = Order.builder()
                .orderLineItems(orderRequest
                        .getOrderLineItemDtos()
                        .stream()
                        .map(this::changeOrderLineItemDtoToEntity)
                        .collect(Collectors
                                .toList()))
                .orderNumber(orderRequest.getOrderNumber())
                .build();
        return order;
    }

    private OrderLineItem changeOrderLineItemDtoToEntity(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .price(orderLineItemDto.getPrice())
                .quantity(orderLineItemDto.getQuantity())
                .skuCode(orderLineItemDto.getSkuCode())
                .build();
    }

    private OrderLineItemDto changeOrderLineItemToDto(OrderLineItem orderLineItem) {
        return OrderLineItemDto.builder()
                .skuCode(orderLineItem.getSkuCode())
                .quantity(orderLineItem.getQuantity())
                .price(orderLineItem.getPrice())
                .id(orderLineItem.getId())
                .build();
    }

    private OrderResponseDto changeEntityToDto(Order order) {
        return OrderResponseDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderLineItemDtos(order
                        .getOrderLineItems()
                        .stream()
                        .map(this::changeOrderLineItemToDto)
                        .toList())
                .build();
    }
}
