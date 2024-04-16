package com.vincent.gptspringbootmd.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.vincent.gptspringbootmd.entity.Goods;
import com.vincent.gptspringbootmd.entity.GoodsExcelDTO;
import com.vincent.gptspringbootmd.entity.GoodsNotGood;
import com.vincent.gptspringbootmd.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class GoodsListener implements ReadListener<GoodsExcelDTO> {

    private GoodsService goodsService;
    private List<GoodsExcelDTO> goodsExcelDTOList = ListUtils.newArrayList();
    private final List<Goods> goodsList = ListUtils.newArrayList();

    public GoodsListener() {

    }
    public GoodsListener(GoodsService goodsService) {
        this.goodsService=goodsService;
    }
    @Override
    public void invoke(GoodsExcelDTO goodsExcelDTO, AnalysisContext analysisContext) {
        goodsExcelDTOList.add(goodsExcelDTO);
        for(GoodsExcelDTO item : goodsExcelDTOList) {
            System.out.println(item.toString());
        }

        GoodsNotGood goodsNotGood = new GoodsNotGood(goodsExcelDTO, "falied");

    }

    private void saveFile(MultipartFile file) throws IOException {
    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
