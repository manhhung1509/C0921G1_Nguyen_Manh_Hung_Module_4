package com.codegym.cart_manager.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void subProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            if (currentValue == 1) {
                removeProduct(productDto);
            } else if (currentValue > 1) {
                productMap.put(productDto, currentValue - 1);
            }
        }
    }

    public double getTotal() {
        double totalMoney = 0.0;
        Set<ProductDto> set = productMap.keySet();
        for (ProductDto key : set) {
            totalMoney += key.getPrice() * productMap.get(key);
        }
        return totalMoney;
    }

    public void removeProduct(ProductDto productDto) {
        productMap.remove(productDto);
    }
}
