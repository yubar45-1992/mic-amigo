package com.shm.order.Resource;

import com.shm.order.dto.OrderRequestDto;
import com.shm.order.dto.OrderResponseDto;
import com.shm.order.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequestDto orderRequest) {

        return CompletableFuture.supplyAsync(()-> orderService.save(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequestDto orderRequestDto,RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->"something wrong try again ");
    }


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<OrderResponseDto> getAllOrders(){
    return orderService.findAll();
    }
}
