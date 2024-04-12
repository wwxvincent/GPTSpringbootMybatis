package com.vincent.gptspringbootmd.service.common.impl;

import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import com.vincent.gptspringbootmd.service.common.ExcelImportStrategy;
import com.vincent.gptspringbootmd.util.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelIndexImportStrategy  {

    @Autowired
    private ExcelReader excelReader;

    public List<ExcelIndexEntity> process(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            List<ExcelIndexEntity> entities = excelReader.readExcel(inputStream );
            // validation code
            for (ExcelIndexEntity entity: entities) {
                System.out.println(entity.toString());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return null;
    }


}
