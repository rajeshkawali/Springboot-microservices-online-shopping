package com.rajeshkawali;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {
    public static final String CLASS_NAME = NotificationServiceApplication.class.getName();

    public static void main(String[] args) {
        String _function = ".main";
        log.info(CLASS_NAME + _function + "::ENTER");
        SpringApplication.run(NotificationServiceApplication.class, args);
        log.info(CLASS_NAME + _function + "::EXIT");
    }
}