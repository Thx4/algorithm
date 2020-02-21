package queuewithstack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPNStack(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1,op2;

        for (String s: tokens) {
            switch (s) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN.evalRPNStack(tokens));
    }
}
