package com.springboot.eCommerce.service;

import com.springboot.eCommerce.entity.Product;
import com.springboot.eCommerce.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


   Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    @Async
    public CompletableFuture<List<Product>> fetchProductList(){
        logger.info("get list of products by "+Thread.currentThread().getName());
        List<Product> products=productRepository.findAll();
        return CompletableFuture.completedFuture(products);
    }

    @Override
    public Product fetchProductById(Long productId){
        return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProductById(Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProductById(Long productId, Product product){
        Product prodDB= productRepository.findById(productId).get();
        prodDB.setProductName(product.getProductName());
        prodDB.setProductPrice(product.getProductPrice());
        prodDB.setProductStock(product.getProductStock());

        return productRepository.save(prodDB);
    }
}
