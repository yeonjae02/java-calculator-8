package calculator.domain;

public class StringCalculator {
    private record Expression(String numberString, String delimeter) {}

    public long addNumbers(String exp) {
        if (isEmptyString(exp)) return 0;
        Expression expression = parseExpression(exp);
        return getSum(expression);
    }

    private long getSum(Expression expression) {
        long sum = 0;
        String[] tokenList = expression.numberString.split(expression.delimeter);
        for (String token : tokenList) {
            sum += validateToken(token);
        }
        return sum;
    }

    private int validateToken(String token) {
        if (token.isEmpty()) return 0;
        try {
            int number = Integer.parseInt(token);
            if (number < 0) throw new IllegalArgumentException("음수는 불가합니다.");
            return number;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }

    private boolean isEmptyString(String exp) {
        return exp == null || exp.isEmpty();
    }

    private Expression parseExpression(String input) {
        if (isCustomSeparatorExist(input)) {
            return new Expression(input.substring(5),String.valueOf(input.charAt(2)));
        }
        return new Expression(input, "[,:]");
    }

    private boolean isCustomSeparatorExist(String input) {
        return input.startsWith("//") && input.length() > 4 && input.charAt(3) == '\\' && input.charAt(4) == 'n';
    }

}