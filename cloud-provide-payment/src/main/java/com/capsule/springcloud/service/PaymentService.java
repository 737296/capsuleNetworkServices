package com.capsule.springcloud.service;
import com.capsule.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;
/**
 * @Author bolin
 * @Date 2022 09 27 14 19
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id")long id);
}
