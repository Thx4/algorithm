package exam.nowcoder;

import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class SubIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = in.nextInt();
        }
        int res = 1;

        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<length;i++) {
            if (stack.size() < 2) {
                stack.push(array[i]);
            } else {
                int pop = stack.pop();
                if (pop >= stack.peek() && array[i] >= pop) {
                    stack.push(pop);
                    stack.push(array[i]);
                } else if (pop < stack.peek() && array[i] < pop) {
                    stack.push(pop);
                    stack.push(array[i]);
                } else {
                    stack = new Stack<>();
                    res++;
                }
            }



        }

        System.out.println(res);

    }
}
