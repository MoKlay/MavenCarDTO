package com.example.carapp.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CarModelDTO_Test {
  @Test
  public void testCreateCarModelDTO() {
    CarModelDTO car1 = new CarModelDTO(1, "Brand1", "Model1", "Country1", "Code1");

    assertEquals(1, car1.getId());
    assertEquals("Brand1", car1.getBrand());
    assertEquals("Model1", car1.getModel());
    assertEquals("Country1", car1.getCountryOrigin());
    assertEquals("Code1", car1.getCountryCode());

  }
}
