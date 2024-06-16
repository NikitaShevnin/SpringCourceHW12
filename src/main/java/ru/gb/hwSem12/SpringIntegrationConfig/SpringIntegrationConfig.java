package ru.gb.hwSem12.SpringIntegrationConfig;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import ru.gb.hwSem12.services.UserRequestService;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    @Bean
    public MessageChannel userRequestChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "userRequestChannel")
    public MessageHandler userRequestHandler(UserRequestService userRequestService) {
        return message -> {
            HttpServletRequest request = (HttpServletRequest) message.getPayload();
            userRequestService.saveUserRequest(request);
        };
    }

    @MessagingGateway
    public interface UserRequestGateway {
        @Gateway(requestChannel = "userRequestChannel")
        void saveUserRequest(HttpServletRequest request);
    }

}
