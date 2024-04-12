package com.vincent.gptspringbootmd.util.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;
import com.vincent.gptspringbootmd.util.ExcelReader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelReaderImpl implements ExcelReader {
    @Override
    public List<ExcelIndexEntity> readExcel(InputStream inputStream) {
        final List<ExcelIndexEntity> indexList = new ArrayList<>();
        //创建EasyExcel读取器
        EasyExcel.read(inputStream, ExcelIndexEntity.class, new AnalysisEventListener<ExcelIndexEntity>() {
            @Override
            public void invoke(ExcelIndexEntity entity, AnalysisContext context) {
                //每当读取一行数据，就会调用此方法
                indexList.add(entity);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 所有数据解析完成
            }
        }).sheet().doRead();

        return indexList;
    }
}
