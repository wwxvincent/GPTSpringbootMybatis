package com.vincent.gptspringbootmd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private String info;
    private String buyTime;
}
