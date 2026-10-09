package com.fpt.aptech.salarymanagement.service;

import com.fpt.aptech.salarymanagement.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> searchUsers(String keyword);

    User getUserById(Long id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
