package com.cydeo.service.impl;


import com.cydeo.model.Product;
import com.cydeo.repository.ProductRepository;
import com.cydeo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public boolean productCreate(Product product){
        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
        return productRepository.findAll().stream().
                filter(product -> product.getId().equals(uuid))
                .findFirst().get();

    }

}
