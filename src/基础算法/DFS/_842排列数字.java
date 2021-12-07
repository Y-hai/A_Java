package 基础算法.DFS;

import jdk.nashorn.internal.ir.LiteralNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _842排列数字 {
    static int N = 12;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n, cnt = 0;
    static int[] q = new int[N];
    static boolean[] st = new boolean[N];

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
            if (!st[i]) {
                q[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}
