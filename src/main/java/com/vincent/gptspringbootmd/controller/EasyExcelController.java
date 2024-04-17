package com.vincent.gptspringbootmd.controller;

import com.alibaba.excel.EasyExcel;
import com.vincent.gptspringbootmd.entity.GoodsNotGood;
import com.vincent.gptspringbootmd.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/easyExcel")
@Api(tags = "easy excel", description = "easy excel upload")
public class EasyExcelController {

    @Value("${base.directory}")
    private String DIRECTORY_PATH;
    @Autowired
    private GoodsService goodsService;

//    @PostMapping(value =  "/upload")
//    public String upload(MultipartFile file) throws IOException {
//        EasyExcel.read(file.getInputStream(), GoodsExcelDTO.class, new GoodsListener(goodMapper)).sheet().headRowNumber(1).doRead();
//        return "success";
//    }

    @PostMapping("/upload&check")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded.");
        }

        try {
            List<GoodsNotGood> goodsNotGoodList = goodsService.processExcel(file.getInputStream());
//        for (GoodsNotGood good : goodsNotGoodList) {
//            System.out.println(good.toString());
//        }
            if (!goodsNotGoodList.isEmpty()) {

                String filePath = "/Users/wenxuanwang/Downloads/test.xlsx";
                EasyExcel.write(filePath, GoodsNotGood.class)
                        .sheet("模板")
                        .doWrite(goodsNotGoodList);
                return ResponseEntity.ok().body("Data processed failed, check the errorList please.");
            } else {
                // 校验成功，不需要下载Excel文件，可以返回其他数据给客户端
                return ResponseEntity.ok().body("Data processed successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the file.");
        }

    }



}
