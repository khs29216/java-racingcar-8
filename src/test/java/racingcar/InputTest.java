package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InputTest {
    @Test
    @DisplayName("자동차 이름을 정상적으로 입력했을 경우, 자동차 이름 리스트를 반환한다.")
    void parseCarNames_정상입력() {
        // given
        String expectedCarNamesInput = "pobi,woni,jun";

        // when
        List<String> actualCarNameList = InputManager.parseCarNames(expectedCarNamesInput);

        // then
        assertThat(actualCarNameList).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름 리스트로 Car 객체 리스트를 생성한다")
    void createCarListFromNames_정상입력() {
        // given
        List<String> expectedCarNameList = List.of("pobi", "woni", "jun");

        // when
        List<Car> actualCarList = CarFactory.createCarListFromNames(expectedCarNameList);

        // then
        List<String> actualCarNameList = actualCarList.stream()
                        .map(Car::getName)
                        .collect(Collectors.toList());
        assertThat(actualCarNameList).containsExactly("pobi", "woni", "jun");
    }
}
