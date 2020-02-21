package queuewithstack;

import java.util.*;

public class ValidParentheses {
    private HashMap<Character, Character> parentheses;

    public ValidParentheses() {
        this.parentheses = new HashMap<>(3);
        parentheses.put('}','{');
        parentheses.put(')','(');
        parentheses.put(']','[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.parentheses.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.parentheses.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
