package com.vincent.gptspringbootmd.controller;

import com.vincent.gptspringbootmd.entity.Company;
import com.vincent.gptspringbootmd.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
@Api(tags = "company Management", description = "Operations pertaining to user management")
public class DepartmentController {
    @Autowired
    private CompanyService companyService;


    @PostMapping("/generatePath")
    @ApiOperation("Generate idPath & cnPath")
    public ResponseEntity<Void> generatePath() {
        companyService.generatePath();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ApiOperation("Get all department")
    public List<Company> getAllUsers() {
        return companyService.getAllDepartments();
    }

    @PostMapping
    @ApiOperation("create a new department")
    public ResponseEntity<Void> insertDepartment(@RequestBody Company company) {
        companyService.insertDepartment(company);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
