package com.vincent.gptspringbootmd.util.impl;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
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
    private static final Log logger = LogFactory.getLog(ExcelReaderImpl.class);

    @Override
    public List<ExcelIndexEntity> readExcel(InputStream inputStream) {
        System.out.println("test:test: inputStream"+inputStream.toString());
        final List<ExcelIndexEntity> indexList = new ArrayList<>();
        //创建EasyExcel读取器
        EasyExcel.read(inputStream, ExcelIndexEntity.class, new AnalysisEventListener<ExcelIndexEntity>() {
            @Override
            public void invoke(ExcelIndexEntity entity, AnalysisContext context) {
                //每当读取一行数据，就会调用此方法
                indexList.add(entity);
                logger.info("read entity: " +entity);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 所有数据解析完成
                logger.info("ALl data has been analysed");
            }
            @Override
            public void onException(Exception e, AnalysisContext context) {
                // 如果发生异常，记录日志
                logger.error("Exception occurred during analysis: " + e.getMessage(), e);
            }
        }).sheet().doRead();

        return indexList;
    }
}
