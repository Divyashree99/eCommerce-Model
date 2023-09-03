package com.springboot.eCommerce.controller;

import com.springboot.eCommerce.entity.Product;
import com.springboot.eCommerce.service.ProductService;
import com.springboot.eCommerce.service.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private StockManagementService stockManagementService;

    @PostMapping("/addproducts")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/getproducts")
    public CompletableFuture<List<Product>> fetchProductList(){
        return productService.fetchProductList();
    }

    @GetMapping("/getproductsbyid/{id}")
    public Product fetchProductById(@PathVariable("id") Long productId){
        return productService.fetchProductById(productId);
    }

    @DeleteMapping("/deleteproductbyid/{id}")
    public String deleteProductById(@PathVariable("id") Long productId){
        productService.deleteProductById(productId);
        return "Product deleted";
    }

    @PutMapping("/updateproductbyid/{id}")
    public Product updateProductById(@PathVariable("id") Long productId, @RequestBody Product product){
        return  productService.updateProductById(productId, product);
    }


    @GetMapping("/getstockcountbyid/{id}")
    public int stockDetails(@PathVariable("id") Long productId, @RequestBody Product product){
         stockManagementService.stockDetails(productId, product);
         return product.getProductStock();
    }

}
