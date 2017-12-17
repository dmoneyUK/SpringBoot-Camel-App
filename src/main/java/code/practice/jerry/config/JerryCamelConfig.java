package code.practice.jerry.config;

import code.practice.jerry.routes.JerryRouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerryCamelConfig {
    @Bean
    public ServletRegistrationBean camelServletRegistration() {
        CamelHttpTransportServlet camelHttpTransportServlet = new CamelHttpTransportServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(camelHttpTransportServlet, "/jerry/*");
        registration.setName("jerryCamelServlet");
        return registration;
    }

    @Bean
    public JerryRouteBuilder jerryRouteBuilder() {
        return new JerryRouteBuilder();
    }

}
