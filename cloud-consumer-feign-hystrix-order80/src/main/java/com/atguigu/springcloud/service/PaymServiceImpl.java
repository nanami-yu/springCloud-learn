package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/8 15:49
 */
@Component
public class PaymServiceImpl implements PaymService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----feign paymentInfo_OK fallback----";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "----feign paymentInfo_timeout fallback----";
    }
}
