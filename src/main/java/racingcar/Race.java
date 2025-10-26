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

    // 테스트용 startRace 메서드
    public void startRace(List<List<Integer>> roundRandomNumbers) {
        for (int i = 0; i < roundCount; i++) {
            playRound(roundRandomNumbers.get(i));
            OutputManager.roundOutput(carList);
        }
        OutputManager.printWinner(findWinners());
    }

    // 실제 사용할 startRace 메서드
    public void startRace() {
        for (int i = 0; i < roundCount; i++) {
            playRound();
            OutputManager.roundOutput(carList);
        }
        OutputManager.printWinner(findWinners());
    }

    // 테스트용 playRound 메서드
    public void playRound(List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(randomNumbers.get(i));
        }
    }

    // 실제 사용할 playRound 메서드
    private void playRound() {
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

}
