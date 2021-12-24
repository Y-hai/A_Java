package Algorithm.数据结构;

import java.io.*;

public class KMP {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = (int) 1e5 + 10;
    static int n, m, ne[] = new int[N];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        String a = in.readLine();
        m = Integer.parseInt(in.readLine());
        String b = in.readLine();
        char[] p = a.toCharArray();
        char[] s = b.toCharArray();
        ne[0] = -1; // 最容易忽略的一步，可以从下标为0开始
        // 预处理
        for (int i = 1, j = -1; i < n; i++) {
            while (j != -1 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        // 匹配
        for (int i = 0, j = -1; i < m; i++) {
            while (j != -1 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n - 1) {
                out.write(Integer.toString(i - n + 1));
                out.write(" ");
                j = ne[j];
            }
        }
        out.flush();
    }
}
