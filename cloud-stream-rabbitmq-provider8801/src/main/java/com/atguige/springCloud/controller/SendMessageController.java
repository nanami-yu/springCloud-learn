package com.atguige.springCloud.controller;

import com.atguige.springCloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/5/28 10:53
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return iMessageProvider.send();
    }
}
