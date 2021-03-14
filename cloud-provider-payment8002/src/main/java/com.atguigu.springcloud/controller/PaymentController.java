package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/3 16:12
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if(result > 0){
            return new CommonResult(200,"插入成功" + serverPost, result);
        }else {
            return new CommonResult(500,"插入失败" + serverPost, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功" + serverPost, payment);
        }else {
            return new CommonResult(500,"查询失败" + serverPost, null);
        }
    }

}
