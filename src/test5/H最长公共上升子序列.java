package test5;

import java.io.*;

import static java.lang.Math.max;

//https://www.acwing.com/problem/content/description/274/

public class H最长公共上升子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 3e3 + 10;
    static int n;
    static int[] a = new int[N], b = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(arr[i - 1]);
        arr = in.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            b[i] = Integer.parseInt(arr[i - 1]);

        for (int i = 1; i <= n; i++) {
            int maxv = 1;
            for (int j = 1; j <= n; j++) {
                if (a[i] == b[j])
                    f[j] = max(f[j], maxv);
                if (b[j] < a[i])
                    maxv = max(maxv, f[j] + 1);
            }
        }
        // 找最后一行中的最大值
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = max(res, f[i]);
        out.write(String.valueOf(res));
        out.flush();
    }
}
