package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 15:22
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix8001.class,args);
    }
}
