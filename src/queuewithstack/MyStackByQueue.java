package queuewithstack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackByQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStackByQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        int res =  q1.remove();
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
