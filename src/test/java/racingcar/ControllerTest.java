package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    private final Controller controller = new Controller(new InputView(), new OutputView());

    @Test
    @DisplayName("시도 횟수만큼 경주를 진행한다.")
    void startRace_테스트() {
        // given
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Race race = new Race(carList, 3);
        List<List<Integer>> roundRandomNumbers = List.of(List.of(5, 3, 7), List.of(1, 1, 1), List.of(6, 3, 3));
        List<Integer> expectedPositions = List.of(2, 0, 1);

        // when
        controller.startRace(race, roundRandomNumbers);

        // then
        List<Integer> actualPositions = carList.stream().map(Car::getPosition).toList();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }
}
