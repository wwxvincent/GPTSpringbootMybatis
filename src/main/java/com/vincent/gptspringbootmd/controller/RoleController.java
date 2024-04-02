package com.vincent.gptspringbootmd.controller;

import com.vincent.gptspringbootmd.entity.Role;
import com.vincent.gptspringbootmd.entity.User;
import com.vincent.gptspringbootmd.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
@Api(tags = "Role Management", description = "Operations pertaining to role management")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    @ApiOperation("Create a new user with role")
    public ResponseEntity<Void> createUser(@RequestBody Role role) {
        roleService.addUserWithRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
