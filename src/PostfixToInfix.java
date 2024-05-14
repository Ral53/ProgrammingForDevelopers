import java.util.Stack;

public class PostfixToInfix {
    public static String postfixToInfix(String expression) {
        // Initialize an empty stack
        Stack<String> stack = new Stack<>();

        // Split the expression into tokens
        String[] tokens = expression.split(" ");

        // Iterate through the postfix expression
        for (String token : tokens) {
            if (Character.isLetterOrDigit(token.charAt(0))) {
                // If operand, push it onto stack
                stack.push(token);
            } else {
                // If operator, pop two operands from stack, enclose them in parentheses, and concatenate with the operator
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                // Push the resulting infix expression onto stack
                stack.push(infixExpression);
            }
        }

        // The final infix expression is obtained by popping the result from stack
        String infixExpression = stack.pop();

        return infixExpression;
    }


}
