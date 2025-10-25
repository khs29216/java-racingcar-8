package racingcar;

import java.util.List;

public class OutputManager {

    public static void roundOutput(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<Car> winnerCarList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerCarList.size(); i++) {
            System.out.print(winnerCarList.get(i).getName());

            if (i < winnerCarList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
