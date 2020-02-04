package com.project.security;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
