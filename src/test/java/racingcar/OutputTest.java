package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    @AfterAll
    static void afterAll() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("라운드 진행시 자동차 이름과 전진상황을 출력한다.")
    void 라운드_출력_테스트() {
        // given
        List<Car> carList = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<List<Integer>> randomNumbers = List.of(List.of(5, 3, 7));
        Race race = new Race(1);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        // when
        race.startRace(carList, randomNumbers);

        // then
        String result = testOutput.toString().trim();
        assertThat("aaa : -\nbbb :\nccc : -\n").isEqualTo(result);
    }
}
