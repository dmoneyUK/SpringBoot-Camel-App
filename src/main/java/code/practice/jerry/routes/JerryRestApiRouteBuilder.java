package code.practice.jerry.routes;

import code.practice.jerry.dtos.JerryCheersResponse;
import code.practice.jerry.dtos.JerryCheeseRequest;
import code.practice.jerry.services.JerryService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import static code.practice.jerry.common.DataFormater.format;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class JerryRestApiRouteBuilder extends RouteBuilder {

    private final JerryService jerryService;

    public JerryRestApiRouteBuilder(JerryService jerryService) {
        this.jerryService = jerryService;
    }

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

                .post("/fridge")
                .type(JerryCheeseRequest.class)
                .route()
                .bean(jerryService, "replenishFridge(${in.body})")
                .endRest();

    }

}
