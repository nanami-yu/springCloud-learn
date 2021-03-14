package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/3 15:52
 */
@Mapper
@Component
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")int id);
}
