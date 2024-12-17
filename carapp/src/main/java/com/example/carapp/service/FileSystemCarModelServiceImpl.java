package com.example.carapp.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.carapp.dto.CarModelDTO;

public class FileSystemCarModelServiceImpl implements FileSystemCarModelService {
  private final List<CarModelDTO> carModelDTOList;

  public List<CarModelDTO> getCarModelDTOList() {
    return carModelDTOList;
  }

  public FileSystemCarModelServiceImpl() {
    carModelDTOList = new ArrayList<>();
  }

  @Override
  public void load(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    try (Scanner scanner = new Scanner(new File(classLoader.getResource(fileName).getFile()))) {
      for (int i = 0; scanner.hasNextLine(); i++) {
        String line = scanner.nextLine();
        if (line.equals("BRAND;MODEL;COUNTRY_ORIGIN;COUNTRY_CODE"))
          continue;
        String[] parts = line.split(";");
        if (parts.length == 4) {
          CarModelDTO carModelDTO = new CarModelDTO(i, parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
          carModelDTOList.add(carModelDTO);
        } else {
          System.err.println("Skipping invalid line" + i + ": " + line);
        }
      }
      System.out.println("Data load successful, total record: " + carModelDTOList.size());
    } catch (IOException e) {
      System.err.println("Error loading data: " + e.getMessage());
    }
  }
}