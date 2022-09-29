package com.capsule.springcloud.order.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bolin
 * @Date 2022 09 27 17 27
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    //开启负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
