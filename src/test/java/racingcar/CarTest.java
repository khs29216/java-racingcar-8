package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("랜덤값이 4이상이면 자동차가 한칸 전진한다.")
    void move_랜덤값_4이상_전진_테스트() {
        // given
        Car car = new Car("pobi");
        int randomNumber = 5;
        int expectedPosition = 1;

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("랜덤값이 3이하면 자동차는 멈춰있는다.")
    void move_랜덤값_3이하_정지_테스트() {
        // given
        Car car = new Car("pobi");
        int randomNumber = 2;
        int expectedPosition = 0;

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
