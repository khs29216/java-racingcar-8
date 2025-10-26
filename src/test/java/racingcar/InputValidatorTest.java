package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    void 빈_문자열_예외_테스트() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames("")),
                () -> assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames(null))
        );
    }

    @Test
    void 문자열_내_공백_예외_테스트() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames("aa, bb")),
                () -> assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames("aaa a,bbb")),
                () -> assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames(" aaa,bbb "))

        );
    }

    @Test
    void 중복_이름_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDuplicateCarNames(
                List.of(
                        new Car("aaa"),
                        new Car("bbb"),
                        new Car("aaa")
                )));
    }

    @Test
    void 이름_길이_5이하_예외_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameLength("ababab"));
    }

    @Test
    @DisplayName("시도할 횟수로 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    void 시도_횟수_문자입력_예외_테스트() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> InputValidator.validateRoundCount("aa")),
                () -> assertThrows(IllegalArgumentException.class, () -> InputValidator.validateRoundCount(" "))
        );
    }

    @Test
    @DisplayName("시도할 횟수로 1이상의 정수를 입력하지 않으면 예외가 발생한다.")
    void 시도_횟수_1이상_예외_테스트() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePositiveNumber(0)),
                () -> assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePositiveNumber(-3))
        );
    }

}
