package util;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.carapp.dto.CarModelDTO;
import com.example.carapp.emtity.CarState;
import com.example.carapp.service.FileSystemCarModelServiceImpl;
import com.example.carapp.util.RandomDataGenerator;

public class RandomDataGeneratorTest {
  private RandomDataGenerator randomDataGenerator;
  private List<CarModelDTO> carModelDTOList;
  private FileSystemCarModelServiceImpl carModelServiceImpl;

  @BeforeEach
  void setUp() {
    carModelServiceImpl = new FileSystemCarModelServiceImpl();
    carModelServiceImpl.load("car.csv");
    carModelDTOList = carModelServiceImpl.getCarModelDTOList(null);
    randomDataGenerator = new RandomDataGenerator();
  }

  @Test
  void getRandomElementTest() {
    CarModelDTO randomCar = randomDataGenerator.getRandomElement(carModelDTOList);
    assertNotNull(randomCar);
    assertTrue(carModelDTOList.contains(randomCar));
  }

  @Test
  void getRandomElementThrowTest() {
    assertThrows(IllegalArgumentException.class, () -> randomDataGenerator.getRandomElement(null));
    assertThrows(IllegalArgumentException.class, () -> randomDataGenerator.getRandomElement(List.of()));
  }

  @Test
  void getRandomColorTest() {
    String color = randomDataGenerator.getRandomColor();
    assertNotNull(color);
    assertTrue(List.of("Red", "Blue", "Green", "Black", "White", "Silver").contains(color));
  }

  @Test
  void getRandomConfigurationTest() {
    String configuration = randomDataGenerator.getRandomConfiguration();
    assertNotNull(configuration);
    assertTrue(List.of("Basic", "Comfort", "Premium", "Sport").contains(configuration));
  }

  @Test
  void getRandomPriceTest() {
    int price = randomDataGenerator.getRandomPrice();
    assertTrue(price >= 20000 && price <= 120000);
  }

  @Test
  void getRandomStateTest() {
    CarState state = randomDataGenerator.getRandomState();
    assertNotNull(state);
    assertTrue(List.of(CarState.values()).contains(state));
  }
}
