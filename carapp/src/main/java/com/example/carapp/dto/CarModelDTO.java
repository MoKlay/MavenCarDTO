package com.example.carapp.dto;

import java.util.Collections;

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

  private String toLine(int length) {
    return String.join("", Collections.nCopies(length, " "));
  }

  @Override
  public String toString() {
    return "Brand:          " + this.brand + "\n" +
        "Model:          " + this.model + "\n" +
        "Country Origin: " + this.countryOrigin + "\n" +
        "Country Code:   " + this.countryCode + "\n";

  }

  public String toString(int line) {
    try {
      return brand + toLine(line - brand.length()) +
          model + toLine(line - model.length()) +
          countryOrigin + toLine(line - countryOrigin.length()) +
          countryCode + toLine(line - countryCode.length());
    } catch (NullPointerException e) {
      return "";
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + ((countryOrigin == null) ? 0 : countryOrigin.hashCode());
    result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CarModelDTO other = (CarModelDTO) obj;
    if (id != other.id)
      return false;
    else if ((brand == null && other.brand != null) || !brand.equals(other.brand))
      return false;
    else if ((model == null && other.model != null) || !model.equals(other.model))
      return false;
    else if ((countryOrigin == null && other.countryOrigin != null) || !countryOrigin.equals(other.countryOrigin))
      return false;
    else
      return !((countryCode == null && other.countryCode != null) || !countryCode.equals(other.countryCode));
  }

  public boolean equalsBrand(String brand) {
    return this.brand.equals(brand);
  }

  public boolean equalsModel(String model) {
    return this.model.equals(model);
  }

  public boolean equals(int id) {
    return id == this.id;
  }
}
