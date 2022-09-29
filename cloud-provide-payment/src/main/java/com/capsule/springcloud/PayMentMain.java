package com.capsule.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Author bolin
 * @Date 2022 09 27 12 02
 **/
@SpringBootApplication
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
//@MapperScan(value = "com.capsule.springcloud.mapper")
public class PayMentMain {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain.class,args);
    }
}

