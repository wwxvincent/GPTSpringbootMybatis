package com.vincent.gptspringbootmd.controller;

import com.vincent.gptspringbootmd.entity.Company;
import com.vincent.gptspringbootmd.service.CompanyService;
import com.vincent.gptspringbootmd.service.common.ExcelImportStrategy;
import com.vincent.gptspringbootmd.service.common.impl.ExcelIndexImportStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("api/readCheckWrite")
@Api(tags = "readCheckWrite", description = "Read excel and check and deal")
public class ReadCheckWriteController {
    @Autowired
    private ExcelIndexImportStrategy excelIndexImportStrategy;


    private static final String UPLADED_FOLDER = "/Users/wenxuanwang/Desktop/2ndRadar/test.xlsx";
    @PostMapping("/upload")
    @ApiOperation("only read and display now")
    public ResponseEntity<Void> generatePath() {
        File file = new File(UPLADED_FOLDER);
        excelIndexImportStrategy.process(file);
        return ResponseEntity.ok().build();
    }



}
