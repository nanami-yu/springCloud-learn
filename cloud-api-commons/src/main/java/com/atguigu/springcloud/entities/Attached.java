package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/10 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attached implements Serializable {
    private String type;
    private String url;
    private String name;
}
