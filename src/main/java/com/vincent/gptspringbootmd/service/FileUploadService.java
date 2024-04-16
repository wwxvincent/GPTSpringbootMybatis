package com.vincent.gptspringbootmd.service;

import com.vincent.gptspringbootmd.entity.UploadFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    String uploadFile(MultipartFile file) throws IOException;
}
