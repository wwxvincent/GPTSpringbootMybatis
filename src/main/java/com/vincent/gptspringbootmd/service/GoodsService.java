package com.vincent.gptspringbootmd.service;

import com.vincent.gptspringbootmd.entity.Goods;
import com.vincent.gptspringbootmd.entity.GoodsNotGood;

import java.io.InputStream;
import java.util.List;

public interface GoodsService {

    List<GoodsNotGood> processExcel(InputStream inputStream);
}
