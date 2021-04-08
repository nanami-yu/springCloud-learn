package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/8 11:37
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHysOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHysOrder80.class,args);
    }
}
