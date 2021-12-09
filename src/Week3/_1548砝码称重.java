package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1548砝码称重 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 27;
    static int n, m, tmp;
    static int[] q = new int[N];
    static boolean ok;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" "); // 注意这里是正则表达式
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        // 读入砝码重量
        arr = in.readLine().split(" "); // 注意这里是正则表达式
        for (int i = 1; i <= n; i++) {
            q[i] = Integer.parseInt(arr[i - 1]);
        }
        // 读入物品重量
        arr = in.readLine().split(" "); // 注意这里是正则表达式
        for (int i = 0; i < m; i++) {
            tmp = Integer.parseInt(arr[i]);
            dfs(0, 1);
            System.out.println(ok ? "YES" : "NO");
            ok = false;
        }
    }

    private static void dfs(int sum, int u) {
        if (sum == tmp) {
            ok = true;
        }
        if (u <= n) {
            dfs(sum + q[u], u + 1);
            dfs(sum, u + 1);
            dfs(sum - q[u], u + 1);
        }
    }
}
