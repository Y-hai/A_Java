package Test;

import java.io.*;

public class Example05 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = (int) 1e5 + 10;
    static int a, b;
    static int[] ne = new int[N];

    public static void main(String[] args) throws IOException {
        a = Integer.parseInt(in.readLine());
        String P = in.readLine();
        b = Integer.parseInt(in.readLine());
        String M = in.readLine();
        char[] p = P.toCharArray();
        char[] m = M.toCharArray();
        ne[0] = -1;
        // 预处理
        for (int i = 1, j = -1; i < a; i++) {
            while (j != -1 && p[j + 1] != p[i]) j = ne[j];
            if (p[j + 1] == p[i]) j++;
            ne[i] = j;
        }
        // 匹配
        for (int i = 0, j = -1; i < b; i++) {
            while (j != -1 && p[j + 1] != m[i]) j = ne[j];
            if (p[j + 1] == m[i]) j++;
            if (j == a - 1) {
                out.write(Integer.toString(i - a + 1));
                out.write(" ");
                j = ne[j];
            }
        }
        out.flush();
    }
}
