package com.vincent.gptspringbootmd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("api/download")
@Api(tags = "download", description = "download file")
public class FileDownLoadController {

    @Value("${base.directory}")
    private   String DIRECTORY_PATH;
    @Value("${base.path}")
    private String BASE_PATH;

    @PostMapping("/pathDownload")
    public ResponseEntity<Resource> downloadFileFromDirectory() throws IOException {
        ClassPathResource resource = new ClassPathResource(DIRECTORY_PATH);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+resource.getFilename()+"");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    @ApiOperation("下载模版")
    @PostMapping("/downloadTemplate")
    public ResponseEntity<Resource> downloadTemplate() throws UnsupportedEncodingException {
        log.info("下载模版");
        ClassPathResource resource = new ClassPathResource(DIRECTORY_PATH);
//        if(!resource.exists()) return ResponseEntity.status(org.springframework.http.HttpStatusHttpStatus.NOT_FOUND);
        if(!resource.exists()) return (ResponseEntity<Resource>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        String fileName = URLEncoder.encode(Objects.requireNonNull(resource.getFilename()), "UTF-8");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

//        return ResponseEntity.ok()
//                .header(headers)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);

        return ResponseEntity.ok()
                .header(String.valueOf(headers))
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    @ApiOperation("运行中文字符下载")
    @PostMapping("/downloadPro")
    public ResponseEntity<Resource> downloadFilePro() throws IOException {
        Path path = Paths.get("/Users/wenxuanwang/Desktop/中文名字测试.xlsx");
        File file = path.toFile();
        if (!file.exists() || !file.isFile()) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new FileSystemResource(file);
        // set response header
        String fileName = URLEncoder.encode(resource.getFilename(), "UTF-8");
        HttpHeaders headers = new HttpHeaders();
        //headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }




//    @GetMapping("/{filePath:.+}")
    @PostMapping("/testFile")
    public ResponseEntity<Resource> downloadFile () {

        Path file = Paths.get(BASE_PATH).normalize().toAbsolutePath();

        if (!Files.exists(file) || !Files.isReadable(file)) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new FileSystemResource(file);
        String fileName = file.getFileName().toString();
        MediaType mediaType = MediaType.parseMediaType(getFileType(fileName));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(mediaType)
                .body(resource);
    }

    // 根据文件扩展名判断文件类型
    private String getFileType(String fileName) {
        String type = "application/octet-stream";
        if (fileName.endsWith(".txt")) {
            type = "text/plain";
        } else if (fileName.endsWith(".docx")) {
            type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        } else if (fileName.endsWith(".xlsx")) {
            type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        } else if (fileName.endsWith(".pdf")) {
            type = "application/pdf";
        }
        // 可以根据需要添加更多的文件类型
        return type;
    }
}
