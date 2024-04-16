package com.vincent.gptspringbootmd.controller;

import com.vincent.gptspringbootmd.service.FileUploadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("api/uploadOnly")
@Api(tags = "upload", description = "upload file only")

public class FileUploadController {
//    @Value("${base.uploadDir}")
//    private String DIRECTORY_PATH;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please upload a file");
//        }
//
//        try {
//            // 获取文件名并构建目标文件路径
//            String fileName = file.getOriginalFilename();
//            String filePath = DIRECTORY_PATH + File.separator + fileName;
//
//            // 将文件保存到目标路径
//            File dest = new File(filePath);
//            file.transferTo(dest);
//
//            return ResponseEntity.ok("File uploaded successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
//        }
//    }

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String message = fileUploadService.uploadFile(file);
        return ResponseEntity.ok(message);

    }


}
