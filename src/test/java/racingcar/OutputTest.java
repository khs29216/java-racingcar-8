package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    private final Controller controller = new Controller(new InputView(), new OutputView());

    @AfterAll
    static void afterAll() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("라운드 진행시 자동차 이름과 위치를 출력한다.")
    void 라운드_출력_테스트() {
        // given
        List<Car> carList = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<List<Integer>> randomNumbers = List.of(List.of(5, 3, 7));
        Race race = new Race(carList, 1);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        // when
        controller.startRace(race, randomNumbers);

        // then
        String result = testOutput.toString().trim();
        assertThat(result).contains("aaa : -\nbbb : \nccc : -");
    }

    @Test
    void winnersPrint_우승자_한_명_테스트() {
        // given
        List<Car> carList = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<List<Integer>> randomNumbers = List.of(List.of(5, 3, 3));
        Race race = new Race(carList, 1);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        // when
        controller.startRace(race, randomNumbers);

        // then
        String result = testOutput.toString().trim();
        assertThat(result).contains("최종 우승자 : aaa");
    }

    @Test
    void winnersPrint_우승자_여러_명_테스트() {
        // given
        List<Car> carList = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<List<Integer>> randomNumbers = List.of(List.of(5, 3, 7));
        Race race = new Race(carList, 1);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        // when
        controller.startRace(race, randomNumbers);

        // then
        String result = testOutput.toString().trim();
        assertThat(result).contains("최종 우승자 : aaa, ccc");
    }
}
