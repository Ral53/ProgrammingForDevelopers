public class CheckParentheses {
    boolean isValid(String s) {
        Stacks stk = new Stacks(s.length());
        String openingBraces = "[{(";
        String closingBraces = ")}]";
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '[' ||  bracket == '{' || bracket == '(') {
                stk.push(bracket);
            }
            else {
                int index = closingBraces.indexOf(bracket);
                char crossOpeningBracket = openingBraces.charAt(index);
                if (stk.isEmpty()) {
                    return false;
                } else {
                    char stkChk = stk.pop();
                    if (crossOpeningBracket != stkChk) {
                        return false;
                    }
                }
            }
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }
}

