package com.example.carapp.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.carapp.dto.CarModelDTO;

public interface CarService {
  Set<String> getAllBrands();

  List<CarModelDTO> getModelsByBrand(String brand);

  Map<String, Integer> getCarsCountByBrand();
}
