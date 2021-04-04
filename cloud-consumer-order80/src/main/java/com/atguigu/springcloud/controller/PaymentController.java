package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/4 9:57
 */
@RestController
@Slf4j
public class PaymentController {

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")int id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/createEntity")
    public CommonResult<Payment> createEntity(Payment payment){
        // return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create",payment,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentByIdEntity(@PathVariable("id")int id){
        // return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
        ResponseEntity<CommonResult> common =  restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);

        if(common.getStatusCode().is2xxSuccessful()){
            return common.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

}
