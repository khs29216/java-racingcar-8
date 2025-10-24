package racingcar;

import java.util.List;

public class Race {
    private final int roundCount;

    public Race(int roundCount) {
        this.roundCount = roundCount;
    }

    // 테스트용 startRace 메서드
    public void startRace(List<Car> carList, List<List<Integer>> roundRandomNumbers) {
        for (int i = 0; i < roundCount; i++) {
            playRound(carList, roundRandomNumbers.get(i));
        }
    }

    // 테스트용 playRound 메서드
    public static void playRound(List<Car> carList, List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(randomNumbers.get(i));
        }
    }

    // 실제 사용할 playRound 메서드
    private static void playRound(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
