import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Postfix Calculator (Supports floating-point numbers)");
        System.out.println("Enter a postfix expression or type 'exit' to quit.");

        while (true) {
            System.out.print("\nExpression: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator terminated.");
                break;
            }

            try {
                double result = evaluatePostfix(input);
                System.out.printf("Result: %.4f%n", result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operation: " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperation(token, a, b);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Malformed expression. Stack has " + stack.size() + " values.");
        }

        return stack.pop();
    }

    public static boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") ||
               token.equals("/") || token.equals("%");
    }

    public static double applyOperation(String operator, double a, double b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero.");
                return a / b;
            case "%":
                if (b == 0) throw new ArithmeticException("Modulo by zero.");
                return a % b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
