package com.bootcamp.product.mapper;

import com.bootcamp.product.model.Product;
import com.bootcamp.product.model.ProductRequest;
import com.bootcamp.product.model.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements EntityMapper<Product, ProductResponse, ProductRequest> {

    @Override
    public ProductResponse toModel(Product domain) {
        ProductResponse product = new ProductResponse();
        product.setId(domain.getId());
        product.setName(domain.getName());
        product.setCategory(domain.getCategory());
        product.setType(domain.getType());
        product.setDescription(domain.getDescription());
        return product;
    }

    @Override
    public Product toDocument(ProductRequest model) {
        Product product = new Product();
        product.setName(model.getName());
        product.setCategory(model.getCategory());
        product.setType(model.getType());
        product.setDescription(model.getDescription());
        return product;
    }
}