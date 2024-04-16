package com.vincent.gptspringbootmd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("read_check_sample")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelIndexEntity {
//    private Integer id;
    private String IndexChineseName;
    private String IndexNickName;
    private String IndexMetrics;
    private String IndexDefine;
    private String IndexType;
    private Integer IndexNumber;
    private Integer IndexNumber2;
    private Integer IndexNumber3;

    private String FailureReason;
}
