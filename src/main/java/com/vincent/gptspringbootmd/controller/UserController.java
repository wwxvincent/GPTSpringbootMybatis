package com.vincent.gptspringbootmd.controller;

import com.vincent.gptspringbootmd.entity.User;
import com.vincent.gptspringbootmd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@Api(tags = "User Management", description = "Operations pertaining to user management")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation("Get all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    // ********** check here and understand every single line for this method
    // ********** what dose the responseEntity for
    @GetMapping("/{id}")
    @ApiOperation("Get user by ID")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    // ********** why capital the Void
    // ********** same here, understand the ResponseEntity work here
    @PostMapping
    @ApiOperation("Create a new user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/batch")
    @ApiOperation("Insert users in batch")
    public ResponseEntity<Void> insertUserInBatch(@RequestBody List<User> users) {
        userService.insertBatch(users);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update an existing user")
    public ResponseEntity<Void> updateUser(@PathVariable(value = "id") Integer userId,
                                           @RequestBody User user) {
        user.setId(userId);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a user")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long userId,
                                           @RequestBody User user) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("byDepartment/{departmentId}")
    public ResponseEntity<List<Map<String, Object>>> getUsersByDepartmentId(@PathVariable Long departmentId) {
        List<Map<String, Object>> users = userService.findUsersByDepartmentId(departmentId);;
        return ResponseEntity.ok(users);
    }
}
