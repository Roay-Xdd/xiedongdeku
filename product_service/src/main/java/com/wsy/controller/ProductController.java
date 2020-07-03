package com.wsy.controller;

import com.wsy.entity.Product;
import com.wsy.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Value("${server.port}")
    private int port;


    //解决跨域请求
//    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.DELETE,
//            RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.HEAD},origins = "*")

    @ApiOperation("根据商品id查看商品信息")//api文档描述
    @ApiImplicitParams({ //参数介绍
            @ApiImplicitParam(name = "id" ,value="商品id" , required = true
            , dataType = "Integer" , paramType = "query"
            ) // required 是否为必填
    })
    @ResponseBody
    @GetMapping("getProductById")
    public Map<String, Object> getProductById(@RequestParam("id") Integer id){
        Product product = productService.getProductById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("product",product);
        map.put("message","查询端口号为："+port+"的商品信息");
        System.out.println("查询端口号为："+port+"的商品信息");
//        System.out.println("环境："+env);
        return map;
    }

    @ResponseBody
    @PostMapping("saveProduct")
    public String saveProduct(@RequestBody Product product){
        System.out.println("保存商品"+product);
        return "保存成功！";
    }
}
