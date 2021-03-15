package com.atguige.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/15 17:44
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springCloud with zk :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
