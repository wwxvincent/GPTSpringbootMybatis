//package com.vincent.gptspringbootmd.test;
//
//import com.vincent.gptspringbootmd.entity.User;
//import com.vincent.gptspringbootmd.mapper.UserMapper;
//import com.vincent.gptspringbootmd.service.UserService;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import static junit.framework.TestCase.assertTrue;
//
//public class UserTest {
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testInsertUser() {
//        User user = new User();
//        user.setName("wwx");
//        user.setEmail("w@gmail.com");
//        userService.createUser(user);
//
//        List<User> users = userService.getAllUsers();
//        assertTrue(users.contains(user));
//    }
//
//}
