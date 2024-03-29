package com.capsule.springcloud.payment02.controller;

import com.capsule.springcloud.payment02.service.PaymentService;
import com.capsule.springcloud.pojo.CommonResult;
import com.capsule.springcloud.pojo.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author bolin
 * @Date 2022 09 27 14 30
 * <p>
 * <p>
 * 提供restful服务  供其他服务调用
 **/
@RestController
@Slf4j //日志注解
public class PaymentControler {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment dept) {
        int i = paymentService.create(dept);
        log.info("***************插入成功**********" + i);
        if (i > 0) {
            return new CommonResult(200, "插入数据库成功", i);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") long id) {
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }

    @GetMapping("/payment/get/serial/{serial}")
    public CommonResult queryByserial(@PathVariable("serial") String serial) {
        Payment payment = paymentService.queryByserial(serial);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() throws InterruptedException {

        return "8002";
    }
}
