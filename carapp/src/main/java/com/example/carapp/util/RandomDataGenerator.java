package com.example.carapp.util;

import java.util.List;
import java.util.Random;

import com.example.carapp.emtity.CarState;

public class RandomDataGenerator {
  private final Random random;
    private final List<String> colors = List.of("Red", "Blue", "Green", "Black", "White", "Silver");
    private final List<String> configurations = List.of("Basic", "Comfort", "Premium", "Sport");
    public RandomDataGenerator() {
       this.random = new Random();
    }
    public  <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
    public String getRandomColor() {
        return colors.get(random.nextInt(colors.size()));
    }
    public String getRandomConfiguration() {
        return configurations.get(random.nextInt(configurations.size()));
    }
    public int getRandomPrice(){
        return random.nextInt(100000) + 20000;
    }
    public CarState getRandomState(){
        CarState[] states = CarState.values();
        return states[random.nextInt(states.length)];
    }
}
