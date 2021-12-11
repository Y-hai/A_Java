package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1548砝码称重 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 27;    // 砝码最多24个，开大点防止溢出
    static int n, m, tmp;
    static int[] q = new int[N];    // 储存砝码
    static boolean ok;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" "); // 注意这里是正则表达式
        n = Integer.parseInt(arr[0]);   // n个砝码
        m = Integer.parseInt(arr[1]);   // m个物品
        // 读入砝码重量
        arr = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            q[i] = Integer.parseInt(arr[i - 1]);
        }
        // 读入物品重量
        arr = in.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            tmp = Integer.parseInt(arr[i]); // tmp代表当前待判断物品重量
            dfs(0, 1);
            System.out.println(ok ? "YES" : "NO");
            ok = false; // 重置为false
        }
    }

    private static void dfs(int sum, int u) {
        if (sum == tmp) {
            // 如果在放置砝码过程中组合出当前物品重量
            ok = true;
        }
        // 如果砝码没有放完
        if (u <= n) {
            // 每个砝码只有3种情况
            dfs(sum + q[u], u + 1); // 第u个砝码放在左边
            dfs(sum, u + 1);             // 第u个砝码不用
            dfs(sum - q[u], u + 1); // 第u个砝码放在右边
        }
    }
}
