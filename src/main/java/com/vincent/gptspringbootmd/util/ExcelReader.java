package com.vincent.gptspringbootmd.util;

import java.io.InputStream;
import java.util.List;

public interface ExcelReader <T> {
    List<T> readExcel (InputStream inputStream);
}
