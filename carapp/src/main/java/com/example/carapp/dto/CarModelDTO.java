package com.example.carapp.dto;

public class CarModelDTO {
  private final int id;
  private String brand;
  private String model;
  private String countryOrigin;
  private String countryCode;

  // constructors
  public CarModelDTO(int id, String brand, String model, String countryOrigin, String countryCode) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.countryOrigin = countryOrigin;
    this.countryCode = countryCode;
  }

  // getters
  public int getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getCountryOrigin() {
    return countryOrigin;
  }

  public String getCountryCode() {
    return countryCode;
  }

  // setters
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setCountryOrigin(String countryOrigin) {
    this.countryOrigin = countryOrigin;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
}
