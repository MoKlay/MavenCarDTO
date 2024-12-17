package com.example.carapp.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.carapp.dto.CarModelDTO;

public class FileSystemCarModelServiceImpl_Test {
  private FileSystemCarModelServiceImpl fileSystemCarModelServiceImpl;
  String filePath = "car.csv";

  @Test
  public void testLoadCarModel() {
    fileSystemCarModelServiceImpl = new FileSystemCarModelServiceImpl();
    assertAll(() -> fileSystemCarModelServiceImpl.load(filePath));

    List<CarModelDTO> list = fileSystemCarModelServiceImpl.getCarModelDTOList();
    assertEquals(3262, list.size());
  }

}
