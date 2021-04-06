package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 10:54
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class,args);
    }

}
