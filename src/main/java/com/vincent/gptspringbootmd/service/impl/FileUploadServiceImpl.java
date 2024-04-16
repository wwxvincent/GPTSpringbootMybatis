package com.vincent.gptspringbootmd.service.impl;

import com.vincent.gptspringbootmd.entity.UploadFileInfo;
import com.vincent.gptspringbootmd.mapper.FileUploadMapper;
import com.vincent.gptspringbootmd.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadMapper fileUploadMapper;

    @Value("${base.uploadDir}")
    private String DIRECTORY_PATH;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        Date date = new Date();
        String fileOriginalFilename = file.getOriginalFilename();
        int dotIndex = fileOriginalFilename.lastIndexOf('.');
        String fileExtension = fileOriginalFilename.substring(dotIndex);
        String fileNameWithoutExtension = fileOriginalFilename.substring(0,dotIndex);
        String fileName = fileNameWithoutExtension + "_" + date.getTime() + fileExtension;
        System.out.println(fileName);
        String filePath = DIRECTORY_PATH + File.separator + fileOriginalFilename;

        //upload to target path
        File dest = new File(filePath);
        file.transferTo(dest);

        // 新建上传表格对象。将上传成功的文件信息保存到数据库
        UploadFileInfo fileInfo = new UploadFileInfo();
        fileInfo.setFileName(fileOriginalFilename);
        fileInfo.setFilePath(filePath);
        fileInfo.setCreateTime(date);
        // 设置创建人，你可以根据需要设置
        fileInfo.setCreatedBy("Admin");
        //fileUploadMapper.save(fileInfo);

        return "File uploaded successfully";
    }

}
