package com.vincent.gptspringbootmd.service.impl;

import com.alibaba.excel.EasyExcel;
import com.vincent.gptspringbootmd.entity.Goods;
import com.vincent.gptspringbootmd.entity.GoodsExcelDTO;
import com.vincent.gptspringbootmd.entity.GoodsNotGood;
import com.vincent.gptspringbootmd.listener.GoodsListener;
import com.vincent.gptspringbootmd.mapper.GoodsMapper;
import com.vincent.gptspringbootmd.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsNotGood> processExcel(InputStream inputStream) {
        GoodsListener excelListener = new GoodsListener(goodsMapper);
        EasyExcel.read(inputStream, GoodsExcelDTO.class, excelListener).sheet().doRead();

        // 有不好的list就返回不好list，不然就调用mapper，写进数据库
        if (!excelListener.getGoodsNotGoodList().isEmpty()) {
//            for(GoodsNotGood goodsNotGood : excelListener.getGoodsNotGoodList()){
//                System.out.println(goodsNotGood.toString());
//            }
            return excelListener.getGoodsNotGoodList();
        } else {
            for(GoodsExcelDTO goodsExcelDTO : excelListener.getGoodsExcelDTOList()){
                System.out.println(goodsExcelDTO.toString());
            }
//            goodsMapper.batchInsert(excelListener.getGoodsExcelDTOList());
            return null;
        }
    }



}
