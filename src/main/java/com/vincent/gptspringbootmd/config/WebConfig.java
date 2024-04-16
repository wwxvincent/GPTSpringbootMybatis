//package com.vincent.gptspringbootmd.config;
//
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.unit.DataSize;
//
//import javax.servlet.MultipartConfigElement;
//
////限制上传文件大小
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//
//        // 设置单个文件最大大小，单位可以是MB或KB
//        factory.setMaxFileSize(DataSize.parse("2MB"));
//        // 设置请求的最大大小，单位可以是MB或KB
//        factory.setMaxRequestSize(DataSize.parse("10MB"));
//
//        return factory.createMultipartConfig();
//    }
//}
