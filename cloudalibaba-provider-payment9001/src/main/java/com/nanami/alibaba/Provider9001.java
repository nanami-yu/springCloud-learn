package com.nanami.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/31 11:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9001.class, args);
    }
}
