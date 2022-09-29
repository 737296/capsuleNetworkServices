package com.capsule.springcloud.payment02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Author bolin
 * @Date 2022 09 27 12 02
 **/
@SpringBootApplication
@EnableEurekaClient
//@MapperScan(value = "com.capsule.springcloud.mapper")
public class PayMentMain02 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain02.class,args);
    }
}

