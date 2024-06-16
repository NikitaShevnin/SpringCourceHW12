package ru.gb.hwSem12.integration;

import jakarta.servlet.http.HttpServletRequest;

public interface UserRequestGateway {
    void saveUserRequest(HttpServletRequest request);
}

