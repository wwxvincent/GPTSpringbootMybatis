package com.vincent.gptspringbootmd.service.impl;

import com.vincent.gptspringbootmd.entity.User;
import com.vincent.gptspringbootmd.mapper.UserMapper;
import com.vincent.gptspringbootmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    // multiple table search
    @Override
    public List<Map<String, Object>> findUsersByDepartmentId(Long departmentId) {
        return userMapper.findAllUsersWithDepartment(departmentId);
    }

    @Override
    @Transactional
    public int insertBatch(List<User> users) {
//        for(User user : users ) {
//            System.out.println(user.toString());
//        }
        return userMapper.insertBatch(users);
    }
}
