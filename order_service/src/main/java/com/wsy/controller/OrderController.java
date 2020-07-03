package com.wsy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsy.entity.Product;
import com.wsy.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("api/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @ResponseBody
    @GetMapping("getProductById")
    @HystrixCommand(fallbackMethod = "getProductFallBack")
    public Object getProductById(Integer id){

        Product product = orderService.findProductById(id);
        return product;
    }

    //熔断处理方法，要求方法的返回类型和参数与api方法一致
    private Object getProductFallBack(Integer id){
        logger.error("商品ID为"+id+"的商品服务调用失败！");
        System.out.println("商品ID为"+id+"的商品服务调用失败！");
        return null;
    }
}
