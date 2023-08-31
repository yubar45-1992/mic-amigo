package com.shm.product.resource;

import com.shm.product.Service.ProductService;
import com.shm.product.dto.CreateProductDto;
import com.shm.product.dto.ResponseProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-service")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductDto createProductDto){
    productService.save(createProductDto);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseProductDto> getAllProducts(){
    return productService.getProducts();
    }



}
