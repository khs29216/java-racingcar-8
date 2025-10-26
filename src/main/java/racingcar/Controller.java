package racingcar;

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

        race.startRace();
    }
}
