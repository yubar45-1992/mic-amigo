package com.hossein.product.Service;

import com.hossein.product.dto.CreateProductDto;
import com.hossein.product.dto.ResponseProductDto;
import com.hossein.product.entity.Product;
import com.hossein.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private ProductRepository productRepository;

    @Transactional
    public void save(CreateProductDto createProductDto) {
        Product product = productRepository.save(Product.builder()
                .name(createProductDto.getName())
                .description(createProductDto.getDescription())
                .price(createProductDto.getPrice())
                .build());
        log.info("product {} is saved", product.getId());

    }

    public List<ResponseProductDto> getProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ResponseProductDto> responseProductDtos = new ArrayList<>();
        if (!allProducts.isEmpty()) {
            allProducts.forEach(product -> {
                ResponseProductDto productDto = ResponseProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build();
                responseProductDtos.add(productDto);
            });
        }
        return responseProductDtos;


    }
}
