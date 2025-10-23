package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(",")).toList();
    }
}
