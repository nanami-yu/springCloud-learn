package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.PaymentMain8001;
import com.atguigu.springcloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
public class PaymentControllerTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void create() {
        System.out.println(paymentService.getPaymentById(1));
    }

    @Test
    public void getPaymentById() {
    }
}