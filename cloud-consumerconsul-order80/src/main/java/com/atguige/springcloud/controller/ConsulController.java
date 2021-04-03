package com.atguige.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/1 17:13
 */
@RestController
@Slf4j
public class ConsulController {

    private static final String PATH = "http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/consul")
    public String getConsul(){
        String s = restTemplate.getForObject(PATH+"/payment/consul",String.class);
        return s;
    }
}
