package com.vincent.gptspringbootmd.service.impl;

import com.vincent.gptspringbootmd.entity.Company;
import com.vincent.gptspringbootmd.mapper.CompanyMapper;
import com.vincent.gptspringbootmd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> getAllDepartments() {
        return companyMapper.getAllDepartments();
    }

    @Override
    public void insertDepartment(Company company) {
        companyMapper.insertDepartment(company);
    }

    @Override
    public void generatePath() {
        List<Company> departments = companyMapper.getAllDepartments();
        for (Company department : departments) {
            String idPath = generateIdPath(department.getId());
            String cnPath = generateCnPath(department.getId());
            department.setIdPath(idPath);
            department.setCnPath(cnPath);
            companyMapper.updatePath(department);
        }
    }

    private String generateIdPath(int id) {
        if (id == 1) {
            return "/"+String.valueOf(id);
        }
        Company parent = companyMapper.getDepartmentById(companyMapper.getDepartmentById(id).getPid());
        return generateIdPath(parent.getId()) +"/" +id;
    }

    private String generateCnPath(int id) {
        if(id == 1) {
            return "/"+companyMapper.getDepartmentById(id).getName();
        }
        Company parent = companyMapper.getDepartmentById(companyMapper.getDepartmentById(id).getPid());
        return generateCnPath(parent.getId())+"/"+companyMapper.getDepartmentById(id).getName();
    }


}
