import java.util.*;

public class MathExpressionEvaluator {
    public static double evaluate(String expression) {
        List<String> postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private static List<String> infixToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                output.add(num.toString());
                continue;
            }

            if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.pop(); // Remove '('
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            }
            i++;
        }

        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }
        return output;
    }

    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        // String expression = "(3+5)*(2-1)/4";
        String expression = "(3+5)*(2-1)";
        // String expression = "(5*(3+(4/2)*3-6))/(9*(5-3/2))";

        System.out.println("Result: " + evaluate(expression)); // Output: 2.0
    }
}
