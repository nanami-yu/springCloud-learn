package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: 主启动类
 * @date 2021/3/3 14:21
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
