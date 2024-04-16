package com.vincent.gptspringbootmd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GoodsNotGood extends Goods{
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
