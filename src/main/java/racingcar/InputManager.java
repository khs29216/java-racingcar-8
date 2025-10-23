package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    public static String input() {
        return Console.readLine();
    }

    public static List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(",")).toList();
    }
}
