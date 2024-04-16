package com.vincent.gptspringbootmd.service.impl;

import com.vincent.gptspringbootmd.entity.Goods;
import com.vincent.gptspringbootmd.mapper.GoodsMapper;
import com.vincent.gptspringbootmd.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional
    @Override
    public void batchInsert(List<Goods> goodsList) {
        goodsMapper.batchInsert(goodsList);
    }
}
