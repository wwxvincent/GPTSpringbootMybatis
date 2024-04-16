package com.vincent.gptspringbootmd.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsExcelDTO {

    @ExcelProperty(index = 0)
    private Integer id;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private String info;

    @ExcelProperty(index = 3)
    private String buyTime;
}
