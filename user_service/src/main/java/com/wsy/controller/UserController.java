package com.wsy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsy.entity.Product;
import com.wsy.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("api/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("getProductById")
    public Object getProductById(Integer id){
        Map map = userService.getProductById(id);
        Object object = map.get("product");
        Product product = null;
        if (object!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            product = objectMapper.convertValue(object,Product.class);
        }
        return product;
    }
    @ResponseBody
    @PostMapping("saveProduct")
    public String saveProduct(Product product){
        String result = userService.saveProduct(product);
        return result;
    }

    @GetMapping("getIndex")
    public String getIndex(){
        return "index";
    }
}
