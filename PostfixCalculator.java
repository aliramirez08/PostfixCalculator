import java.util.*;

public class PostfixCalculator {

    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfixExpression.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Error: Not enough operands for operator '" + token + "'");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Error: Invalid token '" + token + "'");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Error: Invalid postfix expression (too many operands)");
        }

        return stack.pop();
    }

    private boolean isNumeric(String token) {
        return token.matches("-?\\d+");
    }

    private boolean isOperator(String token) {
        return "+-*/%".contains(token);
    }

    private int applyOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Error: Division by zero");
                return a / b;
            case "%":
                if (b == 0) throw new ArithmeticException("Error: Modulo by zero");
                return a % b;
            default: throw new IllegalArgumentException("Error: Unknown operator");
        }
    }

    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Postfix Calculator!");
        System.out.println("Enter your postfix expression with space-separated tokens.");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("Enter expression: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                int result = calculator.evaluatePostfix(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
