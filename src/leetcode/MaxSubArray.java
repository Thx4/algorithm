package leetcode;

public class MaxSubArray {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * */
    public int maxSubArray(int[] nums) {
        /**
         * f(i)=max{f(i−1)+nums[i],nums[i]}
         我们用 f(i)f(i) 代表以第 ii 个数结尾的「连续子数组的最大和
         */

        int pre = 0, maxAns = nums[0];

        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
