package com.fpt.aptech.salarymanagement.repository;

import com.fpt.aptech.salarymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);

    List<User> findByNameContainingIgnoreCase(String name);
}
