package com.example.carapp.dto;

import java.util.Objects;

import com.example.carapp.emtity.CarState;

public class CarDTO {
  private String id;
  private CarModelDTO carModelDTO;
  private String color;
  private int price;
  private String configuration;
  private CarState carState;

  public CarDTO(String id, CarModelDTO carModelDTO, String color, int price, String configuration, CarState carState) {
    this.id = id;
    this.carModelDTO = carModelDTO;
    this.color = color;
    this.price = price;
    this.configuration = configuration;
    this.carState = carState;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CarModelDTO getCarModelDTO() {
    return carModelDTO;
  }

  public void setCarModelDTO(CarModelDTO carModelDTO) {
    this.carModelDTO = carModelDTO;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getConfiguration() {
    return configuration;
  }

  public void setConfiguration(String configuration) {
    this.configuration = configuration;
  }

  public CarState getCarState() {
    return carState;
  }

  public void setCarState(CarState carState) {
    this.carState = carState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CarDTO carDTO = (CarDTO) o;
    return price == carDTO.price && Objects.equals(id, carDTO.id) && Objects.equals(carModelDTO, carDTO.carModelDTO)
        && Objects.equals(color, carDTO.color) && Objects.equals(configuration, carDTO.configuration)
        && carState == carDTO.carState;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, carModelDTO, color, price, configuration, carState);
  }

  @Override
  public String toString() {
    return "CarDTO{" +
        "id='" + id + '\'' +
        ", carModelDTO=" + carModelDTO +
        ", color='" + color + '\'' +
        ", price=" + price +
        ", configuration='" + configuration + '\'' +
        ", carState=" + carState +
        '}';
  }
}
