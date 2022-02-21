package test5;

import java.io.*;

//https://www.acwing.com/problem/content/899/

public class G最长公共子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e3 + 10;
    static int f[][] = new int[N][N];

    public static void main(String args[]) throws IOException {
        // 读入数据
        String[] str = in.readLine().split(" ");
        int len1 = Integer.parseInt(str[0]);
        int len2 = Integer.parseInt(str[1]);
        StringBuilder s1 = new StringBuilder(in.readLine());
        StringBuilder s2 = new StringBuilder(in.readLine());
        s1.insert(0, " ");
        s2.insert(0, " ");

        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                if (s1.charAt(i) == s2.charAt(j))
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                else
                    f[i][j] = Math.max(f[i - 1][j - 1], Math.max(f[i - 1][j], f[i][j - 1]));

        out.write(String.valueOf(f[len1][len2]));
        out.flush();
    }
}
