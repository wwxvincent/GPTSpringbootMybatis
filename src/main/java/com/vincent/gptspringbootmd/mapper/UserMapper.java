package com.vincent.gptspringbootmd.mapper;

import com.vincent.gptspringbootmd.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
//    @Select("select * from gptDB.user")
    List<User> getAllUsers();
    User getUserById(Long id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    // request from multiple tables
    @MapKey("id")
    List<Map<String, Object>> findAllUsersWithDepartment(Long departmentId);
    // insert batch
    int insertBatch(@Param("users") List<User> users);
}
