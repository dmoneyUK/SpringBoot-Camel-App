package code.practice.jerry.routes;

import code.practice.jerry.dtos.JerryCheersResponse;
import code.practice.jerry.dtos.JerryCheeseRequest;
import code.practice.jerry.services.JerryService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static code.practice.jerry.utils.DataFormater.format;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Component
public class JerryRouteBuilder extends RouteBuilder {

    @Autowired
    private JerryService jerryService;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet&servletName=jerryCamelServlet")
                .host("localhost")
                .bindingMode(RestBindingMode.json)
                .port(8080)
                .skipBindingOnErrorCode(false);

        rest("/")
                .consumes(APPLICATION_JSON_VALUE)
                .produces(APPLICATION_JSON_VALUE)

                .get("/cheers")
                .route()
                .bean(jerryService, "cheers")
                .marshal(format(JerryCheersResponse.class))
                .end()
                .endRest()

                .post("/fridge/{name}/{date}")
                .type(JerryCheeseRequest.class)
                .route()
                .process(exchange -> {
                    exchange.getOut().setBody(new JerryCheeseRequest(exchange.getIn().getHeader("name").toString(), exchange.getIn().getHeader("date").toString()));
                })
                .bean(jerryService, "replenishFridge")
                .endRest()

        ;

    }

}
