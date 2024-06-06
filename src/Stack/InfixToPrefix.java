class InfixToPrefix {

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray(); // Convert the input string to a character array
        int left = 0; // Initialize the left pointer to the beginning of the array
        int right = charArray.length - 1; // Initialize the right pointer to the end of the array

        // Loop until the left pointer is less than the right pointer
        while (left < right) {
            // Check if the current characters are '(' or ')'
            if (charArray[left] == '(') {
                charArray[left] = ')';
            } else if (charArray[left] == ')') {
                charArray[left] = '(';
            }

            if (charArray[right] == '(') {
                charArray[right] = ')';
            } else if (charArray[right] == ')') {
                charArray[right] = '(';
            }

            // Swap the characters at positions left and right
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            // Move the left pointer to the right and the right pointer to the left
            left++;
            right--;
        }
        // Convert the character array back to a string and return it
        return new String(charArray);
    }

    static void infixToPrefix(String infixExpression) {
        // Reverse the infix expression
        String reverseInFix = InfixToPrefix.reverseString(infixExpression);
        // Convert the reversed infix expression to postfix
        String postfixExpression = InfixToPostFix.convertPostFix(reverseInFix);
        // Reverse the postfix expression
        String reversedPostFix = InfixToPrefix.reverseString(postfixExpression);

        // Print original and reversed infix expressions
        System.out.println("Original infix expression: " + infixExpression);
        System.out.println("Reverse inflix expression: " + reverseInFix);
        System.out.println("Postfix expression: " + postfixExpression);
        System.out.println("Reversed postfix=prefix expression: " + reversedPostFix);
    }

}

//    static String convertPostFix(String infix) {
//        Stacks stk = new Stacks(infix.length());
//        String postfix = "";
//        for (int i = 0; i < infix.length(); i++) {
//            char ch = infix.charAt(i);
//            if (InfixToPostFix.precedence(ch) > 0) {
//                while (!stk.isEmpty() && InfixToPostFix.precedence(ch) <= InfixToPostFix.precedence(stk.peek())) {
//                    postfix = postfix + stk.pop();
//                }
//                stk.push(ch);
//            } else if(ch == ')') {
//                stk.push(ch);
//            } else if(ch == '(') {
//                char x = stk.pop();
//                while (x != ')') {
//                    postfix = postfix + x;
//                    x = stk.pop();
//                }
//            } else {
//                postfix = postfix + ch;
//            }
//        }
//        while (!stk.isEmpty()) {
//            postfix = postfix + stk.pop();
//        }
//        return postfix;
//    }
//}

