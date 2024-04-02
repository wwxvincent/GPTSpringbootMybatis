package com.vincent.gptspringbootmd.service.impl;

import com.vincent.gptspringbootmd.entity.Role;
import com.vincent.gptspringbootmd.entity.User;
import com.vincent.gptspringbootmd.mapper.CompanyMapper;
import com.vincent.gptspringbootmd.mapper.RoleMapper;
import com.vincent.gptspringbootmd.mapper.UserMapper;
import com.vincent.gptspringbootmd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    //再添加一个CompanyMapper 来确保role表中和company表中name一直，
    // 避开无法添加name 为外键
    // 或许有别的好办法
    @Autowired
    private CompanyMapper companyMapper;

    @Transactional
    @Override
    public int addUserWithRole(Role role) {
        User user = new User();
        user.setName(role.getName());
        user.setDepId(role.getDepartment_id());
        System.out.println("New User: " + user.toString());
        System.out.println("Role info: " + role.toString());
        userMapper.insertUser(user);

        // 就无所谓输入的depart id 和 name 匹配不匹配，根据department id 获取 department name
        role.setDepartment_name( companyMapper.getDepartmentById(role.getDepartment_id()).getName() );

        return roleMapper.addUserWithRole(role);
    }
}
