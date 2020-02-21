package queuewithstack;

import java.util.Stack;

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        DailyTemeratures dailyTemeratures = new DailyTemeratures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemeratures.dailyTemperatures(T));
    }
}