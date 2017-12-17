package code.practice.jerry.dtos;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class JerryCheeseRequest {

    private String name;

    public JerryCheeseRequest(){
    }

    public JerryCheeseRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
