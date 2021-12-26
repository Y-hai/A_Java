package Test;

import java.util.Scanner;

public class Example04 {
    static final int N = 20;
    static boolean[] st = new boolean[N];
    static int n, q[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
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
