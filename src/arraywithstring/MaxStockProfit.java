package arraywithstring;

public class MaxStockProfit {
    /**    给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。

     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     1 <= prices.length <= 3 * 10 ^ 4
     0 <= prices[i] <= 10 ^ 4*/


    public int maxProfit(int[] prices) {
        //dp
        //定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。

        // dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
        // dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}

        //对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候
        // dp[0][0]=0，dp[0][1]=−prices[0]。

        int n = prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//        }
//        return dp[n - 1][0];
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    public int maxProfit1(int[] prices){
        //贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
        int res = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
