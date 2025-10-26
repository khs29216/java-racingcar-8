package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
    }

    private void printPosition(Car car) {
        System.out.print("-".repeat(car.getPosition()));
    }

    public void printWinner(List<Car> winnerCarList) {
        String winners = winnerCarList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }
}
