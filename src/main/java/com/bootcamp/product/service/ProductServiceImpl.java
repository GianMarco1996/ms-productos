package com.bootcamp.product.service;

import com.bootcamp.product.model.Product;
import com.bootcamp.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> registerProduct(Mono<Product> product) {
        return product.flatMap(productRepository::insert);
    }

    @Override
    public Mono<Product> updateProduct(String id, Mono<Product> product) {
        return productRepository.findById(id)
                .flatMap(p -> product)
                .doOnNext(e -> e.setId(id))
                .flatMap(productRepository::save);
    }

    @Override
    public Mono<Void> removeProduct(String id) {
        return productRepository.deleteById(id);
    }
}