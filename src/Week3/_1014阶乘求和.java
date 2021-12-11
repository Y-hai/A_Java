package Week3;

import java.util.Scanner;

public class _1014阶乘求和 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        // 注意用long类型
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += dfs(i);
        }
        System.out.print(res);
    }
    // 不超过20层
    private static long dfs(int n) {
        if (n == 1) return 1;
        return n * dfs(n - 1);
    }
}
