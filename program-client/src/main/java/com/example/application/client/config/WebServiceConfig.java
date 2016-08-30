package com.example.application.client.config;

import com.example.application.client.endpoint.ServiceWSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 */
@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.application.client.service.model");
        return marshaller;
    }

    @Bean
    public ServiceWSClient userClient(Jaxb2Marshaller marshaller) {
        ServiceWSClient client = new ServiceWSClient();
        client.setDefaultUri("http://localhost:8080/server/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
