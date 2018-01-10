package code.practice.jerry.routes;

import code.practice.jerry.common.JerryConstants;
import code.practice.jerry.services.FridgeService;
import org.apache.camel.builder.RouteBuilder;

public class FridgeRouteBuilder extends RouteBuilder {

    private final FridgeService fridgeService;

    public FridgeRouteBuilder(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @Override
    public void configure() {

        from(JerryConstants.FRIDGE_ROUTE_FROM)
                .bean(fridgeService, "putInFridge(${in.body})");
    }
}
