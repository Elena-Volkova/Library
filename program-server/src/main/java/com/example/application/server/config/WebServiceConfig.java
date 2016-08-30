package com.example.application.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * WebServiceConfig
 */
@EnableWs
@EnableWebMvc
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public DefaultWsdl11Definition services(XsdSchema servicesSchema) {
        return createDefinition("ServicesPort", "/ws/services", "http://example.com/application/server/model", servicesSchema);
    }

    private DefaultWsdl11Definition createDefinition(String port, String uri, String namespace, XsdSchema scheme) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(port);
        wsdl11Definition.setLocationUri(uri);
        wsdl11Definition.setTargetNamespace(namespace);
        wsdl11Definition.setSchema(scheme);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema servicesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/services.schema.xsd"));
    }

}
