package code.practice.jerry.services;

import code.practice.jerry.models.Food;

public class FridgeService {

    public String putInFridge(Food food){

        return "Jerry put a [" + food.getName() +"] in the fridge on [" + food.getDate() + "].";

    }
}



