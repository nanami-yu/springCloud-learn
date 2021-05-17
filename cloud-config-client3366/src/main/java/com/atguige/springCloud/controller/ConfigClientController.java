package com.atguige.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/17 17:03
 */
@RestController
public class ConfigClientController {

    @Value("${config.test}")
    private String info;

    @GetMapping("/info")
    public String getInfo(){
        return info;
    }
}
