package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.UploadFileInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FileUploadMapper {

    @Insert("")
    void save(UploadFileInfo fileInfo);
}
