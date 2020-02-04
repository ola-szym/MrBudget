package com.project.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}