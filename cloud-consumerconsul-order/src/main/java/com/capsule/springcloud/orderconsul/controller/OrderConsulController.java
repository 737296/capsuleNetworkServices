package com.capsule.springcloud.orderconsul.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bolin
 * @Date 2022 09 30 15 11
 **/
@RestController
@Slf4j
public class OrderConsulController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul/", String.class);
    }
}
