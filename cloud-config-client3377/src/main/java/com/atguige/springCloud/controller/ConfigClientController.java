package com.atguige.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/26 17:00
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @Value("${config.test}")
    private String info;

    @GetMapping("/info")
    public String getInfo(){
        return "端口号为:" + port + "\t\n\ninfo:" + info;
    }
}
