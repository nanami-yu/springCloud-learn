package com.atguigu.controller;

import com.atguigu.service.PaymentFeignService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 11:04
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") int id){
        CommonResult<Payment> result = null;
        try{
            result = paymentFeignService.getPaymentById(id);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return result;
    }

    /**
     * @Description:默认为等待1秒
     *
     * @author fengyu
     * @date 2021/4/6 13:48
     * @return java.lang.String
     */
    @GetMapping(value = "/timeout")
    public String timeout(){
        String result = null;
        try{
            result = paymentFeignService.timeout();
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return result;
    }

}
