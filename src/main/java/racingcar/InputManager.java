package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    public static List<String> parseCarNames(String carNamesInput) {
        String[] CarNames = carNamesInput.split(",");
        return Arrays.stream(CarNames).toList();
    }
}
