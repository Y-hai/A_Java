package test5;

import java.io.*;

//https://www.acwing.com/problem/content/description/897/

public class E最长上升子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N = (int) 1e3 + 10;
    static int[] f = new int[N], w = new int[N];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            w[i] = Integer.parseInt(str[i - 1]);

        f[1] = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j > 0; j--)
                if (w[i] > w[j])
                    max = Math.max(max, f[j]);
            f[i] = max + 1;
            ans = Math.max(ans, f[i]);
        }

        out.write(String.valueOf(ans));
        out.flush();
    }
}

