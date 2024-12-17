package com.example.carapp.service;

import java.io.FileNotFoundException;

public interface FileSystemCarModelService {
  void load(String fileName) throws FileNotFoundException;
}
