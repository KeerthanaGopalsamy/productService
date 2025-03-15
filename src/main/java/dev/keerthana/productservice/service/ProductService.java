package dev.keerthana.productservice.service;

import dev.keerthana.productservice.models.product;

import java.util.List;

public interface ProductService {
    product getProductById(int id);
    List<product> getAllProducts();
    product createProduct(String category,
                          String description,
                          String imageURL,
                          String title);
}
