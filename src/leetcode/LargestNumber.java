package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class LargestNumber {
    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x,y)->{
            long sx = 10,sy = 10;
            while (sx <= x) {
                sx*=10;
            }
            while (sy <= y) {
                sy*=10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int num : numsArr) {
            res.append(num);
        }
        return res.toString();
    }
}
