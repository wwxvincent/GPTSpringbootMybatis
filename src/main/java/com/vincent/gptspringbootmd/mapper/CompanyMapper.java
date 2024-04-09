package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;

import java.util.List;

@Mapper
public interface CompanyMapper {
    List<Company> getAllDepartments();
    Company getDepartmentById(Integer id);
    void updatePath(Company company);
    void insertDepartment(Company company);

    @Delete("DELETE FROM gptDB.user WHERE id = #{id}")
    boolean deleteDepartment(@Param("id") int id);
}
