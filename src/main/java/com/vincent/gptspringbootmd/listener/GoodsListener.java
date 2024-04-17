package com.vincent.gptspringbootmd.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.vincent.gptspringbootmd.entity.GoodsExcelDTO;
import com.vincent.gptspringbootmd.entity.GoodsNotGood;
import com.vincent.gptspringbootmd.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;




import java.util.List;

@Slf4j
public class GoodsListener implements ReadListener<GoodsExcelDTO> {

    private GoodsMapper goodsMapper;
    private List<GoodsExcelDTO> goodsExcelDTOList = ListUtils.newArrayList();
    //private final List<Goods> goodsList = ListUtils.newArrayList();
    private final List<GoodsNotGood> goodsNotGoodList = ListUtils.newArrayList();

    public GoodsListener(GoodsMapper goodsMapper) {
        this.goodsMapper=goodsMapper;
    }

    //invoke(), 每读一次excel，就执行一次
    @Override
    public void invoke(GoodsExcelDTO goodsExcelDTO, AnalysisContext analysisContext) {
        goodsExcelDTOList.add(goodsExcelDTO);
        //check the input is okay or not
        //for now, all no good
        if(false) {
            goodsNotGoodList.add( new GoodsNotGood(goodsExcelDTO, "something is wrong buddy") );
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("Listener: all not good goods list");
        for(GoodsNotGood goodsNotGood: goodsNotGoodList) {
            System.out.println(goodsNotGood.toString());
        }
    }

    public List<GoodsNotGood> getGoodsNotGoodList() {
        return goodsNotGoodList;
    }
    public List<GoodsExcelDTO> getGoodsExcelDTOList() {
        return goodsExcelDTOList;
    }
}
