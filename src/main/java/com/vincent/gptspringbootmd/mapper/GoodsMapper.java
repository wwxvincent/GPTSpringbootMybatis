package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.Goods;
import com.vincent.gptspringbootmd.entity.GoodsExcelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Update("")
    void batchInsert(List<GoodsExcelDTO> goodsList);
}
