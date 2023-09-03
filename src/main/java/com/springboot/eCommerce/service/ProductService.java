package com.springboot.eCommerce.service;

import com.springboot.eCommerce.entity.Product;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProductService {

    public Product saveProduct(Product product);
    public CompletableFuture<List<Product>> fetchProductList();
    public Product fetchProductById(Long productId);
    public void deleteProductById(Long productId);
    public Product updateProductById(Long productId, Product product);

}
