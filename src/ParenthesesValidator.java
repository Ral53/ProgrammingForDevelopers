public class ParenthesesValidator {
    public static boolean isValid(String s) {
        int top = -1;
        char[] charStack = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    case  '{':
                case '[':
                    charStack[++top] = c;
            }
        }
        return top == -1;
    }

}
