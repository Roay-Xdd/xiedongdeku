package com.wsy.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsy.entity.Product;
import com.wsy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product findProductById(Integer id) {
        Map map = restTemplate.getForObject("http://product-service/api/product/getProductById?id="+id, Map.class);
        Object object = map.get("product");
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.convertValue(object, Product.class);
        return product;
    }
}
