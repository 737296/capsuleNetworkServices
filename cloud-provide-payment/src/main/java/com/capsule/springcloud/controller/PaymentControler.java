package com.capsule.springcloud.controller;
import com.capsule.springcloud.pojo.CommonResult;
import com.capsule.springcloud.pojo.Payment;
import com.capsule.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author bolin
 * @Date 2022 09 27 14 30
 *
 *
 * 提供restful服务  供其他服务调用
 *
 **/
@RestController
@Slf4j //日志注解
public class PaymentControler {

    @Autowired
    private PaymentService paymentService;
    //注入服务发现的注解
    @Autowired
    private DiscoveryClient discoveryClient;

    //获取服务信息
    @GetMapping("/payment/discovery")
    public  Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String s : services){
            log.info("********注册到eureka中的服务中有:"+services);
        }
        List <ServiceInstance> instances = discoveryClient.getInstances("MCROSERVICE-PAYMENT");
        for (ServiceInstance s: instances) {
            log.info("当前服务的实例有"+s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
        }
        return this.discoveryClient;
    }
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment dept){
        int i = paymentService.create(dept);
        log.info("***************插入成功**********"+i);
        if(i>0){
            return new CommonResult(200,"插入数据库成功",i);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") long id){
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }
    //模拟业务接口延时3秒
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        List<String> services = discoveryClient.getServices();
        return "8001";
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB() throws InterruptedException {

        return "8001";
    }
}
