import java.util.Stack;

public class PrefixToInfix {
    public static String prefixToInfix(String expression) {
        Stack<String> stack = new Stack<>();

        // Iterate through the prefix expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                // If operand, push it onto stack
                stack.push(Character.toString(ch));
            } else {
                // If operator, pop two operands from stack, enclose them in parentheses, and concatenate with the operator
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infixExpression = "(" + operand1 + " " + ch + " " + operand2 + ")";
                // Push the resulting infix expression onto stack
                stack.push(infixExpression);
            }
        }

        // The final infix expression is obtained by popping the result from stack
        String infixExpression = stack.pop();

        return infixExpression;
    }
}
