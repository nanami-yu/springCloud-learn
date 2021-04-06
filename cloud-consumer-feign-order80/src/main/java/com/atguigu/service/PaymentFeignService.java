package com.atguigu.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 10:57
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") int id);

    @GetMapping(value = "/timeout")
    String timeout();
}
