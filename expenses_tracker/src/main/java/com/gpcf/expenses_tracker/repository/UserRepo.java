package com.gpcf.expenses_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpcf.expenses_tracker.entity.User;

public interface UserRepo extends JpaRepository<User, Long>
{
    User findByUsername(String username);

}