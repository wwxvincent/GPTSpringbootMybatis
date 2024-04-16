package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ExcelIndexEntityMapper {
    @Update("")
    boolean save(ExcelIndexEntity data);
}
