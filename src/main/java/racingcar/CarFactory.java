package racingcar;

import java.util.List;

public class CarFactory {

    public static List<Car> createCarListFromNames(List<String> carNameList) {
        InputValidator.validateDuplicateCarNames(carNameList);
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }
}
