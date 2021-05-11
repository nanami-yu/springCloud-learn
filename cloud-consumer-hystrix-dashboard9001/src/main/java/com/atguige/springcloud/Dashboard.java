package com.atguige.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/11 13:38
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard.class,args);
    }
}
