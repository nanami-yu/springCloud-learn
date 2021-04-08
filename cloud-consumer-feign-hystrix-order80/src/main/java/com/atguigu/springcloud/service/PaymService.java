package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/8 11:38
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymServiceImpl.class)
public interface PaymService {

    @GetMapping("/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id);
}
