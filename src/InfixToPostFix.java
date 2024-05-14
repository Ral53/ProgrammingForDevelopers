public class InfixToPostFix {

    // Method to determine the precedence of operators
    static int precedence(char ch) {
        if(ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        } else {
            return -1; // Return -1 for non-operator characters
        }
    }

    // Method to convert infix expression to postfix
    static String convertPostFix(String infix) {
        // Initialize stack to store operators
        Stacks stk = new Stacks(infix.length());
        // Initialize an empty string to store the postfix expression
        String postfix = "";
        // Loop through each character in the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            // Check if the character is an operator
            if (precedence(ch) > 0) {
                // Operator
                // While the stack is not empty and the precedence of the current character
                // is less than or equal to the precedence of the operator at the top of the stack
                while (!stk.isEmpty() && precedence(ch) <= precedence(stk.peek())) {
                    // Pop the operator from the stack and append it to the postfix expression
                    postfix = postfix + stk.pop();
                }
                // Push the current operator onto the stack
                stk.push(ch);
            } else if(ch == '(') {
                // If the character is an opening parenthesis, push it onto the stack
                stk.push(ch);
            } else if(ch == ')') {
                // If the character is a closing parenthesis
                // Pop operators from the stack and append them to the postfix expression
                // until an opening parenthesis is encountered
                char x = stk.pop();
                while (x != '(') {
                    postfix = postfix + x;
                    x = stk.pop();
                }
            } else {
                // If the character is neither an operator nor a parenthesis, append it to the postfix expression
                postfix = postfix + ch;
            }
        } // End of for loop

        // Pop any remaining operators from the stack and append them to the postfix expression
        while (!stk.isEmpty()) {
            postfix = postfix + stk.pop();
        }
        // Return the postfix expression
        return postfix;
    }
}
