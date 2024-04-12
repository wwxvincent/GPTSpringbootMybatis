package com.vincent.gptspringbootmd.service.common;

import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ExcelImportStrategy <T> {
    List<T> readFromExcel (File file);
    boolean  validate (List<T> entityList);
    void saveToDataBase(List<T> entityList);

}
