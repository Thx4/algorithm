package queuewithstack;

import java.util.LinkedList;
import java.util.Stack;


public class DecodeString {
//    public String decodeString(String s) {
//        char[] cs = s.toCharArray();
//        String res="";
//        Stack<Character> stack = new Stack<>();
//        int cycleNum = 0;
//
//        for (char c : cs) {
//            if (Character.isDigit(c)) {
//                cycleNum = c;
//            } else {
//                if ("[".equals(c)) {
//                    stack.push(c);
//                } else {
//
//                }
//            }
//
//        }
//    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multiNum = 0;
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> wordsStack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiStack.add(multiNum);
                wordsStack.add(res.toString());
                multiNum = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int currMulti = multiStack.pop();
                for (int i = 0; i < currMulti; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(wordsStack.pop() + temp);

            } else if (Character.isDigit(c)) {
                multiNum = multiNum * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
