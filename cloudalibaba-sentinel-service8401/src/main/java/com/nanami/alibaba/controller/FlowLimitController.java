package com.nanami.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/6/8 14:39
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        return "testA-----------";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB-----------";
    }

}
