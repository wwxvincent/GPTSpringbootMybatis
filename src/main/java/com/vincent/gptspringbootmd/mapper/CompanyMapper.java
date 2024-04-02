package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    List<Company> getAllDepartments();
    Company getDepartmentById(Integer id);
    void updatePath(Company company);
    void insertDepartment(Company company);
}
