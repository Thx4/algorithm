package queuewithstack;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean record[] = new boolean[n];
        while (!queue.isEmpty()) {
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            // 每一层的广度遍历
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                // 说明已到最大平方数
                if (nextVal < 0) {
                    break;
                }

                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if(nextVal == 0) {
                    return step;
                }

                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if(!record[nextVal]){
                    queue.add(new Node(nextVal,step + 1));
                    record[nextVal] = true;
                }
            }
        }
        return -1;
    }
/**
 * //假设最小公式值m = ƒ(n)
 * //那么n的值满足下列公式 ∑(A[i] * A[i]) = n
 * //令 k 为满足最小值 m 的时候，最大的平方数  。 令  d + k * k; = n ;  d >= 0;
 *    // 注意：一定要是满足m最小的时候的k值,一味的取最大平方数,就是贪心算法了
 * //得出 f(d) + f(k*k) = f(n);
 * //显然 f(k*k) = 1; 则  f(d) + 1 = f(n); 因为 d = n - k*k;
 * //则可以推出ƒ(n - k * k) + 1 = ƒ(n) ;  且 k * k <= n;
 * */
    public int numSquares2(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(13));
    }

}


