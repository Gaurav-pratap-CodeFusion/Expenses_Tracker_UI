package com.gpcf.expenses_tracker.service;

import com.gpcf.expenses_tracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpcf.expenses_tracker.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user)
    {
        return repo.save(user);
    }

    public User loginUser(String username, String password)
    {
        User existingUser = repo.findByUsername(username);

        if(existingUser != null && existingUser.getPassword().equals(password))
        {
            return existingUser;
        }

        return null;
    }

}