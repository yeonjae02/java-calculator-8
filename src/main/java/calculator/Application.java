package calculator;

import calculator.domain.StringCalculator;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;


public class Application {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        String exp = CalculatorInput.getUserInput();
        long result = calculator.addNumbers(exp);
        CalculatorOutput.printAnswer(result);
    }

}

