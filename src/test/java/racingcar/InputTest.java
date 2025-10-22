package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InputTest {
    @Test
    @DisplayName("자동차 이름을 정상적으로 입력했을 경우, 자동차 이름 리스트를 반환한다.")
    void 자동차이름_정상적인_입력_테스트() {
        // given
        String carNamesInput = "pobi,woni,jun";

        // when
        List<String> carNameList = InputManager.parseCarNames(carNamesInput);

        // then
        assertThat(carNameList).containsExactly("pobi","woni","jun");
    }

    @Test
    @DisplayName("자동차 이름 리스트로 Car 객체 리스트를 생성한다")
    void Car_리스트_생성_테스트() {
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
