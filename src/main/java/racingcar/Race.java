package racingcar;

import java.util.List;

public class Race {
    private final List<Car> carList;
    private final int roundCount;

    public Race(List<Car> carList, int roundCount) {
        InputValidator.validatePositiveNumber(roundCount);
        this.carList = carList;
        this.roundCount = roundCount;
    }

    // 테스트용 playRound 메서드
    public void playRound(List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(randomNumbers.get(i));
        }
    }

    // 실제 사용할 playRound 메서드
    public void playRound() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
