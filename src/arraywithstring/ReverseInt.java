package arraywithstring;

public class ReverseInt {
    /**    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

     如果反转后整数超过 32 位的有符号整数的范围，就返回 0。

     假设环境不允许存储 64 位整数（有符号或无符号）。*/
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > max / 10 || (res == max / 10 && pop > 7)) {
                return 0;
            }
            if (res < min / 10 || (res == min / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

}
