package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 테스트용 move 메서드
    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    // 실제 사용할 move 메서드
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }
}
