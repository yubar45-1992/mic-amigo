package com.hossein.order.Resource;

import com.hossein.order.dto.OrderRequestDto;
import com.hossein.order.dto.OrderResponseDto;
import com.hossein.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequestDto orderRequest) {
        orderService.save(orderRequest);

    }


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<OrderResponseDto> getAllOrders(){
    return orderService.findAll();
    }
}
