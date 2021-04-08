package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/8 11:40
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallback")
public class PaymController {

    @Resource
    private PaymService paymService;

    @GetMapping("/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    String paymentInfo_timeout(@PathVariable("id") Integer id){
        int age = 10/0;
        return paymService.paymentInfo_timeout(id);
    }

    public String timeOutHandler(Integer id){
        return "服务超时";
    }

    @GetMapping("/global/{id}")
    @HystrixCommand
    public String tryGlobalFallback(@PathVariable("id") Integer id){
        return paymService.paymentInfo_timeout(id);
    }

    public String global_fallback(){
        return "全局fallback";
    }
}
