package com.wsy.service;

import com.wsy.entity.Product;
import com.wsy.service.impl.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "product-service",fallback = UserServiceFallBack.class)
public interface UserService {

    @GetMapping("api/product/getProductById")
    public Map<String, Object> getProductById(@RequestParam("id") Integer id);

    @PostMapping("api/product/saveProduct")
    public String saveProduct(@RequestBody Product product);
}
