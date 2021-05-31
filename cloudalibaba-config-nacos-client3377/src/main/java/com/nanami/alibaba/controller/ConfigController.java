package com.nanami.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/31 14:04
 */
@RestController
@RefreshScope // 动态刷新
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    public String getInfo(){
        return info;
    }
}
