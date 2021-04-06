package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;
import sun.text.resources.sl.JavaTimeSupplementary_sl;

import java.util.concurrent.TimeUnit;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/4/6 15:31
 */
@Service
public class PaymentService {

    /**
     * @Description:正常访问
     *
     * @param id
     * @author fengyu
     * @date 2021/4/6 15:32
     * @return java.lang.String
     */
    public String paymentInfo_OK(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id;
    }

    /**
     * @Description:超时访问
     *
     * @param id
     * @author fengyu
     * @date 2021/4/6 15:34
     * @return java.lang.String
     */
    public String paymentInfo_timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_timeout,id:" + id + " 耗时" + timeNumber +"秒";
    }
}
