package code.practice.jerry.services;

import code.practice.jerry.dtos.JerryCheeseRequest;
import code.practice.jerry.dtos.JerryCheersResponse;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JerryService {

    public JerryCheersResponse cheers(){
        return new JerryCheersResponse("Jerry said cheers :)");

    }

    public String replenishFridge(JerryCheeseRequest request){
        String id = UUID.randomUUID().toString();
        String name = request.getName();

        return "Jerry put a [" + name +"] in the fridge.";

    }
}
