package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1004母牛问题 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 60;    // 这里N代表最大年数
    static int[] dp = new int[N];

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // 动态规划求解，时间复杂度O(n)
        int n = Integer.parseInt(in.readLine());
        while (n != 0) {
            for (int i = 4; i <= n; i++) {
                // dp[i]代表第i年牛的数量
                // 从第四年开始，第i年的牛数等于原本的牛数(dp[i-1])加新出生的牛数(dp[i-3])
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            System.out.println(dp[n]);
            n = Integer.parseInt(in.readLine());
        }
    }
}
