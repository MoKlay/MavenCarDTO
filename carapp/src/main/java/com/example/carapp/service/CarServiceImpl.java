package com.example.carapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.example.carapp.dto.CarModelDTO;

public class CarServiceImpl implements CarService {
  private List<CarModelDTO> cars;

  public CarServiceImpl(List<CarModelDTO> cars) {
    this.cars = cars;
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
}
