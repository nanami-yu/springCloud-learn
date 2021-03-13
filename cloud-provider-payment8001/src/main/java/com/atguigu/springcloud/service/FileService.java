package com.atguigu.springcloud.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

public interface FileService {

    /**
     * @Description:目录上传图片
     *
     * @param file
     * @author fengyu
     * @date 2020/12/9 14:55
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    Map<String, Object> doUpload(MultipartFile file , int id , String fileType);

    /**
     * @Description:回显图片
     *
     * @param filePath
     * @author fengyu
     * @date 2020/12/9 15:28
     * @return java.io.InputStream
     */
    InputStream getPic(String filePath);
}
