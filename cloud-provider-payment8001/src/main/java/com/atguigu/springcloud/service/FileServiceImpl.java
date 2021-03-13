package com.atguigu.springcloud.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.atguigu.springcloud.entities.Attached;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

/**
 * 文件服务（调用 JackRabbit 管理上传后的文件）
 *
 * JackRabbit实现了JSR 170规范，其管理文件的方式是通过维护一棵文件树来管理。
 *
 *
 * @author fengyu
 *
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value(value = "${upload.path}")
    private String uploadPath;

    @Autowired
    PaymentService paymentService;

    /**
     * @param file,type
     * @return java.util.Map<java.lang.String, Object>
     * @Description:目录上传图片
     * @author fengyu
     * @date 2020/12/9 14:55
     */
    @Override
    public Map<String, Object> doUpload(MultipartFile file, int id, String fileType){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            //上传目录地址
            String uploadDir;
            Attached attached = new Attached();
            // 获取文件后缀名
            // 如果没有后缀名，则用uuid代替，解决Contains问题，强制走到else中
            String suffix = String.valueOf(UUID.randomUUID());
            if (file.getOriginalFilename().contains(".")) {
                suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            }
            String fileName = file.getOriginalFilename();
            attached.setName(fileName);
            // 根据日期与类型生成目录
            uploadDir = uploadPath + "/" + LocalDate.now().toString();
            if("1".equals(fileType)){
                uploadDir = uploadDir + "/船级";
            }else if ("2".equals(fileType)){
                uploadDir = uploadDir + "/船厂";
            }
            //如果目录不存在，自动创建文件夹
            File fileDir = new File(uploadDir);
            if(!fileDir.exists())
            {
                fileDir.mkdirs();
            }
            //上传文件名
            String filename = UUID.randomUUID() + suffix;
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + "/" + filename);
            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);
            attached.setUrl(uploadDir + "/" + filename);
            attached.setType(fileType);
            // 查询历史附件
            Payment payment = paymentService.getPaymentById(id);
            String nowAttached = payment.getAttached();
            List<Attached> attList = new ArrayList<>();
            if(nowAttached.length() > 0){

            }else{
                attList.add(attached);
            }
            JSONObject json = JSONUtil.parseObj(attList, false);
            System.out.println(json.toStringPretty());
            payment.setAttached(json.toStringPretty());
            paymentService.create(payment);
        }catch (Exception e) {
            log.info("上传失败",e);
            resultMap.put("status", "2");
            return resultMap;
        }
        return resultMap;
    }

    @Override
    public InputStream getPic(String filePath) {
        InputStream is = null;
        try {
            // is = resourceLoader.getResource("file:" + filePath).getInputStream();
            return is;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return is;
    }
}
