package com.wsy.service.impl;

import com.wsy.entity.Product;
import com.wsy.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> map = new HashMap<>();

    static {
        Product p1 = new Product(1,100.00f,"iphoneX",10);
        Product p2 = new Product(2,200.00f,"iphone11",20);
        Product p3 = new Product(3,300.00f,"iphone12",30);
        map.put(1,p1);
        map.put(2,p2);
        map.put(3,p3);
    }

    @Override
    public Product getProductById(Integer id) {

        Product product = map.get(id);
        return product;
    }
}
