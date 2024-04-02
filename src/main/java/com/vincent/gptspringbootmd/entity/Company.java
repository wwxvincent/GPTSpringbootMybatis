package com.vincent.gptspringbootmd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private Integer id;
    private Integer pid;
    private String idPath;
    private String cnPath;
    private String name;
}
