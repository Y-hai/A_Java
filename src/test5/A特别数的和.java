package test5;

import java.io.*;

//https://www.lanqiao.cn/problems/191/learning/

public class A特别数的和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (cheak(i)) {
                sum += i;
            }
        }
        out.write(String.valueOf(sum));
        out.flush();
    }

    private static boolean cheak(int n) {
        while (n != 0) {
            int a = n % 10;
            if (a == 2 || a == 0 || a == 1 || a == 9)
                return true;
            n /= 10;
        }
        return false;
    }
}
