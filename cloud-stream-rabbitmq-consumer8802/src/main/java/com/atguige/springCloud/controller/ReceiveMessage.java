package com.atguige.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author fengyu
 * @version 1.0
 * @Title: 消费者
 * @date 2021/5/28 11:22
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessage {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者8082->>>>>>>>>>>>" + message.getPayload() + "\t" + port);
    }
}
