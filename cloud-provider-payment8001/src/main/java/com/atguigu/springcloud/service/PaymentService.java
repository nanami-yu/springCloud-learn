package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/3 16:05
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(int id);
}
