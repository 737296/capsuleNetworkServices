package com.capsule.springcloud.payment04;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
/**
 * @Author bolin
 * @Date 2022 09 30 11 40
 **/
public class PaymentMain04 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain04.class, args);
    }
}
