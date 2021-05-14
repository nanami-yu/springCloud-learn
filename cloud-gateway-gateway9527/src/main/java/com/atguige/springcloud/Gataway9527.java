package com.atguige.springcloud;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/14 15:04
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Gataway9527 {
    public static void main(String[] args) {
        SpringApplication.run(Gataway9527.class,args);
    }
}
