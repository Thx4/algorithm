package queuewithstack;

import java.util.Stack;

public class MyQueueByStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public MyQueueByStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

}
