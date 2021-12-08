package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1004母牛问题 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int N = 60;
    static int[] dp = new int[N];

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int n = Integer.parseInt(in.readLine());
        while(n!=0){
            for (int i = 4; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            System.out.println(dp[n]);
            n = Integer.parseInt(in.readLine());
        }
    }
}
