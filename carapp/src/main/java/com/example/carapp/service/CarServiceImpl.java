package com.example.carapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.example.carapp.dto.CarDTO;
import com.example.carapp.dto.CarModelDTO;
import com.example.carapp.emtity.CarState;
import com.example.carapp.util.RandomDataGenerator;

public class CarServiceImpl implements CarService {
  private final RandomDataGenerator randomDataGenerator;
  private List<CarModelDTO> cars;

  public CarServiceImpl(List<CarModelDTO> cars) {
    this.cars = cars;
    this.randomDataGenerator = new RandomDataGenerator();
  }

  public void setCars(List<CarModelDTO> cars) {
    this.cars = cars;
  }

  @Override
  public Set<String> getAllBrands() {
    Set<String> uniqueMarks = new HashSet<>();
    for (CarModelDTO car : cars) {
      uniqueMarks.add(car.getBrand());
    }
    return uniqueMarks;
  }

  @Override
  public List<CarModelDTO> getModelsByBrand(String brand) {
    List<CarModelDTO> models = new ArrayList<>();
    for (CarModelDTO car : cars) {
      if (car.getBrand().equals(brand)) {
        models.add(car);
      }
    }
    return models;
  }

  @Override
  public Map<String, Integer> getCarsCountByBrand() {
    Map<String, Integer> countByBrand = new TreeMap<>();
    for (CarModelDTO car : cars) {
      if (countByBrand.containsKey(car.getBrand())) {
        countByBrand.put(car.getBrand(), countByBrand.get(car.getBrand()) + 1);
      } else {
        countByBrand.put(car.getBrand(), 1);
      }
    }
    return countByBrand;
  }

  @Override
  public List<CarDTO> createRandomCars(int numberOfCars) {
    List<CarDTO> randomCars = new ArrayList<>();
    for (int i = 0; i < numberOfCars; i++) {
      CarModelDTO carModel = randomDataGenerator.getRandomElement(cars);
      String color = randomDataGenerator.getRandomColor();
      int price = randomDataGenerator.getRandomPrice();
      String configuration = randomDataGenerator.getRandomConfiguration();
      CarState state = randomDataGenerator.getRandomState();

      CarDTO carDTO = new CarDTO(String.valueOf(i + 1), carModel, color, price, configuration, state);
      randomCars.add(carDTO);
    }
    return randomCars;
  }

  @Override
  public void timeCheckCreateRandomCars(int numberOfCars) {
    long startTime = System.nanoTime();
    createRandomCars(numberOfCars);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Execution time for creating " + numberOfCars + " random cars: " + duration + " nano seconds");
  }
}
