package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fengyu
 * @version 1.0
 * @Title: 实体
 * @date 2021/3/3 15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private int id;
    private String serial;
    private String attached;
}
