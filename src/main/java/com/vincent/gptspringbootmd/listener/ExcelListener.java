package com.vincent.gptspringbootmd.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.vincent.gptspringbootmd.entity.ExcelIndexEntity;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener<String> {

    private List<String> dataList;

    public ExcelListener(List<String> dataList) {
        this.dataList = dataList;
    }
    @Override
    public void invoke(String entity, AnalysisContext analysisContext) {
        dataList.add(entity);
//        System.out.println(excelIndexEntity.toString());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 所有数据解析完成后会调用的方法，你可以在这里处理failedData，例如写入到新的Excel文件中。
    }

    private boolean validateData(ExcelIndexEntity data) {
        // 在这里添加你的数据校验逻辑，如果数据有效返回true，否则返回false。
        return true; // 示例代码，总是返回true。
    }

    public void writeFailedDataToExcel() {
        // 将failedData写入到一个新的Excel文件中，你可以使用EasyExcel的写功能来完成这个任务。
    }


}
