package racingcar;

import java.util.List;

public class Race {
    private final int roundCount;

    public Race(int roundCount) {
        this.roundCount = roundCount;
    }

    // 테스트용 playRound 메서드
    public static void playRound(List<Car> carList, List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(randomNumbers.get(i));
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
