package code.practice.jerry.services;

import code.practice.jerry.common.JerryConstants;
import code.practice.jerry.dtos.JerryCheeseRequest;
import code.practice.jerry.dtos.JerryCheersResponse;
import code.practice.jerry.models.Food;
import org.apache.camel.ProducerTemplate;

import java.util.UUID;

public class JerryService {

    private final ProducerTemplate producerTemplate;

    public JerryService(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public JerryCheersResponse cheers(){
        return new JerryCheersResponse("Jerry said cheers :)");

    }

    public String replenishFridge(JerryCheeseRequest request){

        String id = UUID.randomUUID().toString();
        String name = request.getName();
        String date = request.getDate();

        Food food = new Food(id, name, date);

        return producerTemplate.requestBody(JerryConstants.FRIDGE_ROUTE_FROM, food, String.class);



    }

}
