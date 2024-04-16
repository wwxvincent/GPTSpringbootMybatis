package com.vincent.gptspringbootmd.service;

import com.vincent.gptspringbootmd.entity.Goods;

import java.util.List;

public interface GoodsService {
    void batchInsert(List<Goods> goodsList);
}
