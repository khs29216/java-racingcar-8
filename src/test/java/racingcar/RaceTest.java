package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("라운드 진행 시, 각 자동차가 랜덤 값에 따라 이동한다")
    void playRound_테스트() {
        // given
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        List<Integer> randomNumbers = List.of(5, 3, 7);
        List<Integer> expectedPositions = List.of(1, 0, 1);

        // when
        Race.playRound(carList, randomNumbers);

        // then
        List<Integer> actualPositions = carList.stream()
                .map(Car::getPosition)
                .toList();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }

    @Test
    @DisplayName("시도 횟수만큼 경주를 진행한다.")
    void startRace_테스트() {
        // given
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Race race = new Race(3);
        List<List<Integer>> roundRandomNumbers = List.of(List.of(5, 3, 7), List.of(1, 1, 1), List.of(6, 3, 3));
        List<Integer> expectedPositions = List.of(2, 0, 1);

        // when
        race.startRace(carList, roundRandomNumbers);

        // then
        List<Integer> actualPositions = carList.stream()
                .map(Car::getPosition)
                .toList();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }

    @Test
    @DisplayName("가장 멀리간 자동차를 우승자로 선정한다.")
    void findWinners_우승자_한_명_테스트() {
        // given
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Race race = new Race(3);
        List<List<Integer>> roundRandomNumbers = List.of(List.of(5, 3, 7), List.of(1, 1, 1), List.of(6, 3, 3));
        race.startRace(carList, roundRandomNumbers);
        List<Car> expectedWinner = List.of(new Car("pobi"));

        // when
        List<Car> actualWinner = race.findWinners(carList);

        // then
        assertThat(actualWinner).isEqualTo(expectedWinner);
    }

    @Test
    @DisplayName("가장 멀리간 자동차를 우승자로 선정하고, 우승자가 여러 명일 수 있다.")
    void findWinners_우승자_여러_명_테스트() {
        // given
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Race race = new Race(3);
        List<List<Integer>> roundRandomNumbers = List.of(List.of(5, 3, 7), List.of(1, 1, 1), List.of(6, 3, 6));
        race.startRace(carList, roundRandomNumbers);
        List<Car> expectedWinners = List.of(new Car("pobi"), new Car("jun"));

        // when
        List<Car> actualWinners = race.findWinners(carList);

        // then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}
