package leetcode;

public class UglyNumber {
    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 丑数 就是只包含质因数2、3 或5的正整数。
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int i : nums) {
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }

}
