package com.vincent.gptspringbootmd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableSwagger2WebMvc
//@MapperScan("com.vincent.gptspringbootmd.mapper") // 指定 Mapper 接口的扫描路径
@ComponentScan(basePackages = {"com.vincent.gptspringbootmd.*"})
public class GptSpringbootMdApplication {

    public static void main(String[] args) {
        SpringApplication.run(GptSpringbootMdApplication.class, args);
    }

}
