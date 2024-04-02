package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int addUserWithRole(Role role);
}
