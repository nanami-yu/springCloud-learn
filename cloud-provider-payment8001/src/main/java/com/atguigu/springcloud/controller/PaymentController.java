package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.FileServiceImpl;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author fengyu
 * @version 1.0
 * @Title: TODO
 * @date 2021/3/3 16:12
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if(result > 0){
            return new CommonResult(200,"插入成功", result);
        }else {
            return new CommonResult(500,"插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功", payment);
        }else {
            return new CommonResult(500,"查询失败", null);
        }
    }

//    @PostMapping("/payment/upload")
//    public CommonResult upload(@RequestParam("file") MultipartFile file, @RequestParam int id, @RequestParam String ownerType) throws IOException {
//        //String fileId = fileServiceImpl.save(file.getInputStream(),type);
//        // fileType(1:图片，2：视频)
//        Map<String, Object> res = fileService.doUpload(file, id, ownerType);
//        RxUserFileDTO result = null;
//        if ("1".equals(String.valueOf(res.get("status")))) {
//            //将信息保存到IamFileExpand
//            RxUserFileDTO rxUserFileDTO = (RxUserFileDTO)res.get("rxUserFileDTO");
//            rxUserFileDTO.setOwnerType(ownerType);
//            result = rxUserFileService.save(rxUserFileDTO);
//            return ResponseEntity.ok().body(result);
//        } else {
//            return ResponseEntity.status(500).body(result);
//        }
//    }
}
