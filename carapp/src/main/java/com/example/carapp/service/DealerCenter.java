package com.example.carapp.service;

import java.util.List;

import com.example.carapp.dto.CarDTO;

public class DealerCenter {
  private String name;
  private List<CarDTO> cars;

  public DealerCenter(String name, List<CarDTO> cars) {
    this.name = name;
    this.cars = cars;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CarDTO> getCars() {
    return cars;
  }

  public void setCars(List<CarDTO> cars) {
    this.cars = cars;
  }

  @Override
  public String toString() {
    return "DealerCenter{" +
        "name='" + name + '\'' +
        ", cars=" + cars +
        '}';
  }
}
