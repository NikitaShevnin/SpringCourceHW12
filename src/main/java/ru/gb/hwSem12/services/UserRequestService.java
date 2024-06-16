package ru.gb.hwSem12.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Класс который будет отвечать за сохранение запросов в файл
 */
@Service
public class UserRequestService {

    private static final String FILE_PATH = "user_requests.txt";

    public void saveUserRequest(HttpServletRequest request) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String requestInfo = formatRequestInfo(request);
            writer.write(requestInfo + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error saving user request to file", e);
        }
    }

    private String formatRequestInfo(HttpServletRequest request) {
        return "URL: " + request.getRequestURL() +
                ", Method: " + request.getMethod() +
                ", Remote Address: " + request.getRemoteAddr() +
                ", Timestamp: " + LocalDateTime.now();
    }
}

