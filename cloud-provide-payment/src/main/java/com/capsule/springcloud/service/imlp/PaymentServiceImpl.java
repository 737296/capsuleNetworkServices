package com.capsule.springcloud.service.imlp;
import com.capsule.springcloud.dao.PaymentDao;
import com.capsule.springcloud.pojo.Payment;
import com.capsule.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author bolin
 * @Date 2022 09 27 14 27
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    @Override
    public Payment queryById(long id) {
        return paymentDao.queryById(id);
    }
}
