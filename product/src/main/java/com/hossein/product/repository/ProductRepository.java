package com.hossein.product.repository;

import com.hossein.product.dto.ResponseProductDto;
import com.hossein.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductRepository extends MongoRepository<Product, String> {


}
