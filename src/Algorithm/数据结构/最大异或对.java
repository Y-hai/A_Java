package Algorithm.数据结构;

import java.io.*;

public class 最大异或对 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int N = (int) 3e6 + 10;
    // static int[][] son = new int[N][2]; 比下面慢4倍
    static int[][] son = new int[2][N];
    static int[] q = new int[N];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(arr[i]);
            insert(q[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(search(q[i]), res);
        }
        out.write(String.valueOf(res));
        out.flush();
    }

    private static int search(int n) {
        int p = 0, tmp = 0;
        for (int i = 30; i >= 0; i--) {
            int u = n >> i & 1; // &1是为了取最后一位
            int ru = u == 0 ? 1 : 0;
            if (son[ru][p] != 0) {
                tmp += 1 << i;
                p = son[ru][p];
            } else p = son[u][p];
        }
        return tmp;
    }

    private static void insert(int n) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = n >> i & 1;
            if (son[u][p] == 0) son[u][p] = ++idx;
            p = son[u][p]; // 不能等于idx
        }
    }
}
