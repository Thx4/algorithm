package queuewithstack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!min.isEmpty()) {
            if (min.peek() >= x) {
                min.push(x);
            }
        } else {
            min.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
