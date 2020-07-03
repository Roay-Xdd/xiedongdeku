package com.wsy.service.impl;

import com.wsy.entity.Product;
import com.wsy.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceFallBack implements UserService {


    @Override
    public Map<String, Object> getProductById(Integer id) {
        System.out.println("商品ID为"+id+"的商品服务调用失败！");
        Map<String,Object> param = new HashMap<>();
        param.put("product",null);
        param.put("message","商品ID为"+id+"的商品服务调用失败！");
        return param;
    }

    @Override
    public String saveProduct(Product product) {
        System.out.println("商品服务调用保存方法失败");
        return null;
    }
}
