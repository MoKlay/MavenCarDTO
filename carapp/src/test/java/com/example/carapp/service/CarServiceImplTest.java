package com.example.carapp.service;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarServiceImplTest {
  private CarServiceImpl carService;

  private final String filePath = "car.csv";

  @BeforeEach
  void setUp() {
    FileSystemCarModelServiceImpl fileSystemCarModelService = new FileSystemCarModelServiceImpl();
    fileSystemCarModelService.load(filePath);
    carService = new CarServiceImpl(fileSystemCarModelService.getCarModelDTOList(null));
  }

  @Test
  void getAllBrandsTest() {
    Set<String> brands = carService.getAllBrands();
    assertTrue(brands.contains("Toyota"));
    assertTrue(brands.contains("BMW"));
  }

  @Test
  void getModelsByBrandTest() {
    assertAll(() -> carService.getModelsByBrand("Toyota"));
  }

  @Test
  void getCarsCountByBrandTest() {
    assertAll(() -> carService.getCarsCountByBrand());
  }
}
