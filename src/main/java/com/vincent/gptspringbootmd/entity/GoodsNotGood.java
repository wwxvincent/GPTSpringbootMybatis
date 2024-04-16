package com.vincent.gptspringbootmd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsNotGood extends Goods{
    String failedReason;

    public GoodsNotGood(GoodsExcelDTO goodsExcelDTO, String failed) {
        super(); // 如果Goods类的默认构造器中有重要的初始化逻辑，则需要调用
        if (goodsExcelDTO == null) {
            throw new IllegalArgumentException("GoodsExcelDTO cannot be null");
        }
        setId(goodsExcelDTO.getId());
        setName(goodsExcelDTO.getName());
        setInfo(goodsExcelDTO.getInfo());
        setBuyTime(goodsExcelDTO.getBuyTime());
        this.failedReason = failed; // 确保参数名与字段名一致
    }
}
