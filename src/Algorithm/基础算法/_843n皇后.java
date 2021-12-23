package Algorithm.基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _843n皇后 {
    static int N = 20;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n, cnt = 0;
    static int q[] = new int[N];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int u) {
        if (u > n) {
            cnt++;
            for (int i = 1; i <= n; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check(u, i)) {
                q[u] = i;
                dfs(u + 1);
            }
        }
    }

    private static boolean check(int r, int c) {
        for (int i = 1; i < r; i++)
            if (q[i] == c || q[i] - c == i - r || i + q[i] == r + c)
                return false;
        return true;
    }
}
