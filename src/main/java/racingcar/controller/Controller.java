package racingcar.controller;

import racingcar.view.InputManager;
import racingcar.view.OutputManager;
import racingcar.model.*;

import java.util.List;

public class Controller {

    public void execute() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = InputManager.input();
        List<String> carNameList = CarNameParser.parseCarNames(carNamesInput);
        List<Car> carList = CarFactory.createCarListFromNames(carNameList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundCount = InputManager.input();
        InputValidator.validateRoundCount(roundCount);

        Race race = new Race(carList, Integer.parseInt(roundCount));
        startRace(race);
        OutputManager.printWinner(race.findWinners());
    }

    // 실제 사용할 startRace 메서드
    public static void startRace(Race race) {
        for (int i = 0; i < race.getRoundCount(); i++) {
            race.playRound();
            OutputManager.roundOutput(race.getCarList());
        }
    }

    // 테스트용 startRace 메서드
    public static void startRace(Race race, List<List<Integer>> roundRandomNumbers) {
        for (int i = 0; i < race.getRoundCount(); i++) {
            race.playRound(roundRandomNumbers.get(i));
            OutputManager.roundOutput(race.getCarList());
        }
    }
}
