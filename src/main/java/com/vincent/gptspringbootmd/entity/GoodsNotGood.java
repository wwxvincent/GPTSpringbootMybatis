package com.vincent.gptspringbootmd.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class GoodsNotGood extends Goods{
    @ExcelProperty(index = 4)
    String failedReason;

    public GoodsNotGood(GoodsExcelDTO goodsExcelDTO, String failed) {
        super(goodsExcelDTO.getId(), goodsExcelDTO.getName(), goodsExcelDTO.getInfo(), goodsExcelDTO.getBuyTime());
        this.failedReason = failed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Failed Reason: " + failedReason;
    }


}
