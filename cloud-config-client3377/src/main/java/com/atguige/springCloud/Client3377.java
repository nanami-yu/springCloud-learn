package com.atguige.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/26 16:58
 */
@SpringBootApplication
@EnableEurekaClient
public class Client3377 {
    public static void main(String[] args) {
        SpringApplication.run(Client3377.class,args);
    }
}
