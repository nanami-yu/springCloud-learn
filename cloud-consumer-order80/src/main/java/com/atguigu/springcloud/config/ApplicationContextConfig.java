package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/4 10:02
 */
@Configuration
public class ApplicationContextConfig {


    @Bean         // 注册
    @LoadBalanced // 赋予负载均衡能力 注释使用手写
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }

}
