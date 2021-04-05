package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写Ribon算法
 */
public interface LoadBalancer {

    /**
     *
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);


}
