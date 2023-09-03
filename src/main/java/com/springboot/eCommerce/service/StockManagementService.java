package com.springboot.eCommerce.service;

import com.springboot.eCommerce.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class StockManagementService {

    public int stockDetails(Long productId, Product product) {
        int result= product.getProductStock();
        return result;
    }
}
