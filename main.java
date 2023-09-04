import java.util.ArrayList;
import java.util.List;

public class MiniCalculator {
    private List<String> history = new ArrayList<>();

    public double add(double a, double b) {
        double result = a + b;
        addToHistory(a, b, "+", result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        addToHistory(a, b, "-", result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        addToHistory(a, b, "*", result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        double result = a / b;
        addToHistory(a, b, "/", result);
        return result;
    }

    public double power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        addToHistory(base, exponent, "^", result);
        return result;
    }

    public void printHistory() {
        System.out.println("История операций:");
        for (String operation : history) {
            System.out.println(operation);
        }
    }

    private void addToHistory(double a, double b, String operator, double result) {
        history.add(a + " " + operator + " " + b + " = " + result);
    }

    public static void main(String[] args) {
        MiniCalculator calculator = new MiniCalculator();
        try {
            double sum = calculator.add(5, 3);
            double difference = calculator.subtract(10, 4);
            double product = calculator.multiply(6, 7);
            double quotient = calculator.divide(15.0, 5.0);
            double powerResult = calculator.power(2.0, 3.0);

            calculator.printHistory();
        } catch (ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
