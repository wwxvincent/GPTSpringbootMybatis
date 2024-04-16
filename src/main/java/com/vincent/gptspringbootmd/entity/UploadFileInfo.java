package com.vincent.gptspringbootmd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@TableName("not_decide_yet")
@Data
@ApiModel(value = "uploadFileIn", description = "upload files' info here")
public class UploadFileInfo {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "primary key")
    private String id;

    private String fileName;

    private String filePath;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createdBy;


}
