package com.vincent.gptspringbootmd.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import com.vincent.gptspringbootmd.listener.ExcelListener;
import com.vincent.gptspringbootmd.mapper.ExcelIndexEntityMapper;
import com.vincent.gptspringbootmd.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExcelIndexEntityMapper excelIndexEntityMapper;
    @Override
    public void processExcel(InputStream inputStream) {
//        ExcelListener excelListener = new ExcelListener (excelIndexEntityMapper);
//        EasyExcel.read(inputStream, ExcelIndexEntity.class, excelListener);
//
//        // 生成并返回带有校验结果的Excel文件
//        if (!excelListener.getFailedData().isEmpty()) {
//            // 创建一个新的Excel文件，包含原始数据和校验失败的原因
//            excelListener.writeFailedDataToExcel();
//        }

        // 暂时，只读取
        EasyExcel.read(inputStream, ExcelIndexEntity.class, new AnalysisEventListener<ExcelIndexEntity>() {
            @Override
            public void invoke(ExcelIndexEntity data, AnalysisContext context) {
                // 在这里处理每一条读取到的数据，例如保存到数据库
                excelIndexEntityMapper.save(data);
                System.out.println(data.toString());
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 所有数据读取完毕后执行的操作，这里可以留空或添加其他逻辑
            }
        }).sheet().doRead();
    }
}
