package com.fpt.aptech.salarymanagement.service.impl;

import com.fpt.aptech.salarymanagement.entity.User;
import com.fpt.aptech.salarymanagement.repository.UserRepository;
import com.fpt.aptech.salarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchUsers(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllUsers();
        }
        return userRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public User saveUser(User user) {
        // Validation check
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (user.getAge() == null || user.getAge() <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0.");
        }
        if (user.getSalary() == null || user.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0.");
        }

        // Unique Name Check
        if (userRepository.existsByName(user.getName().trim())) {
            throw new IllegalArgumentException("Error while creating User: Unable to create. A User with name " + user.getName().trim() + " already exist.");
        }

        user.setName(user.getName().trim());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID is required for update.");
        }

        User existingUser = getUserById(user.getId());

        // Unique Name Check (excluding current user ID)
        if (userRepository.existsByNameAndIdNot(user.getName().trim(), user.getId())) {
            throw new IllegalArgumentException("Error while updating User: A User with name " + user.getName().trim() + " already exist.");
        }

        existingUser.setName(user.getName().trim());
        existingUser.setAge(user.getAge());
        existingUser.setSalary(user.getSalary());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
