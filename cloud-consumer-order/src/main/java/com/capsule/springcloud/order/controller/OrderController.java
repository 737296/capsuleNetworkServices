package com.capsule.springcloud.order.controller;

import com.capsule.springcloud.pojo.CommonResult;
import com.capsule.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bolin
 * @Date 2022 09 27 17 36
 **/

@RestController
@Slf4j
public class OrderController {
    //调用支付订单服务端的ip+端口号----------调用单机服务端
//    public static final String PAYMENT_URL = "http://localhost:8001";
    //调用支付订单服务端的ip+端口号----------调用集群服务端（服务端支持负载均衡，用注解，轮询）
    public static final String PAYMENT_URL = "http://mcroservice-payment";

    @Autowired
    private RestTemplate restTemplate;

    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
