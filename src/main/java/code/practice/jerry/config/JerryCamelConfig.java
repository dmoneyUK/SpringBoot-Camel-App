package code.practice.jerry.config;

import code.practice.jerry.routes.FridgeRouteBuilder;
import code.practice.jerry.routes.JerryRestApiRouteBuilder;
import code.practice.jerry.services.FridgeService;
import code.practice.jerry.services.JerryService;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerryCamelConfig {

    @Produce
    private ProducerTemplate producerTemplate;

    @Bean
    public ServletRegistrationBean camelServletRegistration() {
        CamelHttpTransportServlet camelHttpTransportServlet = new CamelHttpTransportServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(camelHttpTransportServlet, "/jerry/*");
        registration.setName("jerryCamelServlet");
        return registration;
    }

    @Bean
    public JerryRestApiRouteBuilder jerryRouteBuilder(JerryService jerryService) {
        return new JerryRestApiRouteBuilder(jerryService);
    }

    @Bean
    public JerryService jerryService(){
        return new JerryService(producerTemplate);
    }

    @Bean
    public FridgeRouteBuilder fridgeRouteBuilder(FridgeService fridgeService){
        return new FridgeRouteBuilder(fridgeService);
    }

    @Bean
    public FridgeService fridgeService(){
        return new FridgeService();
    }

}
