package com.example.carapp;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.carapp.dto.CarDTO;
import com.example.carapp.dto.CarModelDTO;
import com.example.carapp.service.CarServiceImpl;
import com.example.carapp.service.DealerCenter;
import com.example.carapp.service.FileSystemCarModelServiceImpl;

public class Main {
  public static void main(String[] args) {
        FileSystemCarModelServiceImpl fileSystemService = new FileSystemCarModelServiceImpl();
        fileSystemService.load("car.csv");
        List<CarModelDTO> carModelDTOList = fileSystemService.getCarModelDTOList(null);

        CarServiceImpl carService = new CarServiceImpl(carModelDTOList);
        int numberOfCars = 1000;
        List<CarDTO> carList = carService.createRandomCars(numberOfCars);
        System.out.println("Generated car list: ");
        carList.forEach(System.out::println);
        System.out.println("-------------------");


        Set<String> brands = carService.getAllBrands();
        System.out.println("All brands: " + brands);
        System.out.println("-------------------");

        List<CarModelDTO> modelsByBrand = carService.getModelsByBrand("Toyota");
        System.out.println("Models by 'Toyota' brand: " + modelsByBrand);
        System.out.println("-------------------");

        Map<String, Integer> carsByBrand = carService.getCarsCountByBrand();
        System.out.println("Count cars by brand: " + carsByBrand);
        System.out.println("-------------------");

        carService.timeCheckCreateRandomCars(10000);
        System.out.println("-------------------");
        DealerCenter dealerCenter = new DealerCenter("My auto dealer", carList);
        System.out.println("Dealer center: " + dealerCenter);
    }
}
