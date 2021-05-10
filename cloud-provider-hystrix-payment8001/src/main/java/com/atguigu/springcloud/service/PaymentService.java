package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        // 测试方法超时
        int timeNumber = 30;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_timeout,id:" + id + " 耗时" + timeNumber +"秒";
        // 测试方法错误
//        int a = 10/0;
//        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_timeout,id:" + id + " 结果为" + a;
    }

    /**
     * @Description:访问超时 降级方法
     *
     * @param id
     * @author fengyu
     * @date 2021/5/10 16:06
     * @return java.lang.String
     */
    public String timeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_timeout,id:" + id + " 服务超时";
    }

    //======================================== 服务熔断 =======================================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    /**
     * @Description:访问超时 降级方法
     *
     * @param id
     * @author fengyu
     * @date 2021/5/10 16:06
     * @return java.lang.String
     */
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "触发降级 id:" + id;
    }
}
