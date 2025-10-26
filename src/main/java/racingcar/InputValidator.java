package racingcar;

import java.util.List;

public class InputValidator {

    private InputValidator() {};

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
    }

    public static void validateNoWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다.");
        }
    }

    public static void validateCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해야 합니다.");
        }
    }

    public static void validateDuplicateCarNames(List<String> inputList) {
        if (inputList.size() != inputList.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateRoundCount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수로 숫자여야 합니다.");
        }
    }

    public static void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도할 횟수를 잘못 입력하셨습니다.");
        }
    }

}
