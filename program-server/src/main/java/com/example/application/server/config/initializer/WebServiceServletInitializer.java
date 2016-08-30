package com.example.application.server.config.initializer;

import com.example.application.server.config.AppConfig;
import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;

/**
 *
 */
public class WebServiceServletInitializer extends AbstractAnnotationConfigMessageDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    public boolean isTransformWsdlLocations() {
        return true;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/ws/*"};
    }
}
