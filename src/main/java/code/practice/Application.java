package code.practice;

import code.practice.jerry.config.JerryCamelConfig;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({JerryCamelConfig.class})
public class Application {

    public static final void main(String[] args){
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
