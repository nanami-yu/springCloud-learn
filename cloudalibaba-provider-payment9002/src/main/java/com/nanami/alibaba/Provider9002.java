package com.nanami.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/31 11:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9002 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9002.class, args);
    }
}
