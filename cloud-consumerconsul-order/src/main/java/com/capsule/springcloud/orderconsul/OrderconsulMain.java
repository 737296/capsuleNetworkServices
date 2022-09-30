package com.capsule.springcloud.orderconsul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author bolin
 * @Date 2022 09 30 11 55
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderconsulMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderconsulMain.class, args);
    }
}
