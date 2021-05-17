package com.atguige.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/17 15:50
 */
@SpringBootApplication
@EnableConfigServer
public class Main3344 {
    public static void main(String[] args) {
        SpringApplication.run(Main3344.class,args);
    }
}
