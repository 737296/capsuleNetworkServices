package com.capsule.springcloud.payment02.dao;
import com.capsule.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author bolin
 * @Date 2022 09 27 14 15
 **/

@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);
    Payment queryById(@Param("id")long id);

}

