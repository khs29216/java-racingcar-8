package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.*;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        String carNamesInput = inputView.inputCarNames();
        InputValidator.validateNotNullOrEmpty(carNamesInput);
        InputValidator.validateNoWhitespace(carNamesInput);
        List<String> carNameList = CarNameParser.parseCarNames(carNamesInput);
        List<Car> carList = CarFactory.createCarListFromNames(carNameList);

        String roundCount = inputView.inputRoundCount();
        InputValidator.validateRoundCount(roundCount);

        Race race = new Race(carList, Integer.parseInt(roundCount));
        startRace(race);
    }

    // 실제 사용할 startRace 메서드
    public void startRace(Race race) {
        for (int i = 0; i < race.getRoundCount(); i++) {
            race.playRound();
            outputView.printRoundResult(race.getCarList());
        }
        outputView.printWinner(race.findWinners());
    }

    // 테스트용 startRace 메서드
    public void startRace(Race race, List<List<Integer>> roundRandomNumbers) {
        for (int i = 0; i < race.getRoundCount(); i++) {
            race.playRound(roundRandomNumbers.get(i));
            outputView.printRoundResult(race.getCarList());
        }
        outputView.printWinner(race.findWinners());
    }
}
