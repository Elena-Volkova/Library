package com.example.application.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 */
@ComponentScan({"com.example.application.server.*"})
@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class AppConfig {
}
