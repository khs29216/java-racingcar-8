package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    public static List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(",")).toList();
    }
}
