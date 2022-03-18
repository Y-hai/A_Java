package test5;

import java.io.*;

//https://www.acwing.com/problem/content/description/1018/

public class F最大上升子序列和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, N = (int) 1e3 + 10;
    static int[] w = new int[N], dp = new int[N];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            w[i] = Integer.parseInt(str[i - 1]);

        int ans = init();
        out.write(String.valueOf(ans));
        out.flush();
    }

    // f[i]代表所有以w[i]结尾的上升子序列的和的最大值
    private static int init() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = w[i];
            for (int j = i - 1; j > 0; j--)
                if (w[i] > w[j])
                    dp[i] = Math.max(dp[i], dp[j] + w[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
