//package com.vincent.gptspringbootmd.test;
//
//import com.vincent.gptspringbootmd.controller.FileDownLoadController;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.io.TempDir;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(FileDownLoadController.class)
//public class FileDownLoadControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @TempDir
//    public Path tempDir;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Test
//    public void testDownloadFile() throws Exception {
//        // 创建一个测试文件
//        File testFile = tempDir.resolve("test.txt").toFile();
//        Files.write(testFile.toPath(), "Test content".getBytes());
//
//        // 模拟请求下载文件
//        MvcResult mvcResult = mockMvc.perform(get("/download/" + testFile.getAbsolutePath()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE))
//                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"test.txt\""))
//                .andReturn();
//
//        // 验证响应体是一个Resource
//        Resource resource = (Resource) mvcResult.getResponse().getContentAsByteArray();
//        assertTrue(resource.exists());
//        assertTrue(resource.isReadable());
//        assertTrue(resource.getFilename().equals("test.txt"));
//
//        // 验证文件内容
//        byte[] contentAsByteArray = Files.readAllBytes(testFile.toPath());
//        assertTrue(java.util.Arrays.equals(contentAsByteArray, mvcResult.getResponse().getContentAsByteArray()));
//    }
//
//    @Test
//    public void testDownloadFileNotFound() throws Exception {
//        mockMvc.perform(get("/download/nonexistent.txt"))
//                .andExpect(status().isNotFound());
//    }
//}