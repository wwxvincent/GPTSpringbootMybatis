package com.vincent.gptspringbootmd.service;

import com.vincent.gptspringbootmd.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void generatePath();

    List<Company> getAllDepartments();
    void insertDepartment(Company company);
}
