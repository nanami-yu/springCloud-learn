package com.atguigu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 14:02
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignlv(){
        return Logger.Level.FULL;
    }
}
