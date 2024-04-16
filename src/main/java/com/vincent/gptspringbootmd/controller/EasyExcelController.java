package com.vincent.gptspringbootmd.controller;

import com.alibaba.excel.EasyExcel;
import com.vincent.gptspringbootmd.entity.GoodsExcelDTO;
import com.vincent.gptspringbootmd.listener.GoodsListener;
import com.vincent.gptspringbootmd.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("api/easyExcel")
@Api(tags = "easy excel", description = "easy excel upload")
public class EasyExcelController {

    @Value("${base.directory}")
    private String DIRECTORY_PATH;
    @Autowired
    private GoodsService goodsService;

    @PostMapping(value =  "/upload")
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), GoodsExcelDTO.class, new GoodsListener(goodsService)).sheet().headRowNumber(1).doRead();
        return "success";
    }


}
