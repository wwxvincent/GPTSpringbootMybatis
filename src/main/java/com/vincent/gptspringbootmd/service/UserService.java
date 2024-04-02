package com.vincent.gptspringbootmd.service;

import com.vincent.gptspringbootmd.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

    List<Map<String, Object>> findUsersByDepartmentId(Long departmentId);
}
