package com.bootcamp.product.service;

import com.bootcamp.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getProducts();
    Mono<Product> getProduct(String id);
    Mono<Product> registerProduct(Mono<Product> product);
    Mono<Product> updateProduct(String id, Mono<Product> product);
    Mono<Void> removeProduct(String id);
}