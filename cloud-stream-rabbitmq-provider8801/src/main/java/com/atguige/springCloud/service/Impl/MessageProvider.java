package com.atguige.springCloud.service.Impl;

import com.atguige.springCloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author fengyu
 * @version 1.0
 * @Title: 调用消息中间件
 * @date 2021/5/28 10:46
 */
//@Service 与mq关联 不需要添加
@EnableBinding(Source.class) //定义消息推送管道
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("******uuid: " + uuid);
        return uuid;
    }

}
