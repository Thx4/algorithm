package queuewithstack;

import java.util.Stack;

public class DailyTemeratures {
    public int[] dailyTemperatures(int[] T) {
        /**
         * 我们用栈记录索引，满足 T[stack[-1]] < T[stack[-2]] < ...，其中 stack[-1] 是栈的顶部，stack[-2] 是从顶部开始的第二个元素，依此类推；我们将在处理每个 T[i] 时保持 stack[-1] > stack[-2] > ...。
         * 我们通过当前温度和栈顶索引所代表的温度比较来找到温度升高的位置。
         * 举个例子：我们反向遍历处理 t=[73，74，75，71，69，72，76，73] ，通过看栈元素的变化来理解是如何工作的。为了清楚 stack 只包含索引 i，但是将把 T[i] 的值写在旁边的括号中，例如 0 (73)
         *
         * */
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        DailyTemeratures dailyTemeratures = new DailyTemeratures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemeratures.dailyTemperatures(T));
    }
}
