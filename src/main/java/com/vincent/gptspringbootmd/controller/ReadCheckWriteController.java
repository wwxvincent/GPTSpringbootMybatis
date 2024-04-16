package com.vincent.gptspringbootmd.controller;

import com.alibaba.excel.EasyExcel;
import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import com.vincent.gptspringbootmd.listener.ExcelListener;
import com.vincent.gptspringbootmd.service.ExcelService;
import com.vincent.gptspringbootmd.service.common.impl.ExcelIndexImportStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/readCheckWrite")
@Api(tags = "readCheckWrite", description = "Read excel and check and deal")
public class ReadCheckWriteController {
    @Autowired
    private ExcelIndexImportStrategy excelIndexImportStrategy;

    @Autowired
    private ExcelService excelService;

    @Value("${base.readPath}")
    private String DOWN_PATH;

    @Value("${base.uploadDir}")
    private String UPLOAD_DIR;

    @PostMapping("/upload1")
    @ApiOperation("only read and display now")
    public ResponseEntity<Void> generatePath() {
        File file = new File(DOWN_PATH);
        excelIndexImportStrategy.process(file);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("请选择一个文件上传", HttpStatus.BAD_REQUEST);
        }
        try {
            //ClassPathResource resource = new ClassPathResource(UPLOAD_DIR);
            System.out.println("开始进入上传");
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.createDirectories(path.getParent());
            // 使用try-with-resources语句自动关闭流
            try (InputStream inputStream = file.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(path.toFile())) {

                // 将输入流中的数据写入到输出流（即文件）中
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                return ResponseEntity.ok("文件上传成功");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/upload111")
    public ResponseEntity<?> uploaddemo(@RequestParam("file") MultipartFile file) throws IOException {
        // ... 文件上传逻辑 ...
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("上传失败，请选择文件");
        }

        List<String> dataList = new ArrayList<>();
        // 文件保存路径
        InputStream inputStream = file.getInputStream();
        System.out.println("easyExcel 之前，");
        System.out.println(inputStream.toString());
        EasyExcel.read(inputStream, ExcelIndexEntity.class, new ExcelListener(dataList)).sheet().doRead();
        System.out.println("easy Excel 之后");
        System.out.println("dataList size is "+ dataList.size());
        for (String entity : dataList) {
            System.out.println(entity.toString());
        }

        return ResponseEntity.ok().build();

    }






}
