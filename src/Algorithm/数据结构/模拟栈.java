package Algorithm.数据结构;

import java.io.*;

public class 模拟栈 {
    // 整型转换为字符串不要直接 + ""，非常慢！
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int M, q[] = new int[N], idx = 0;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            String[] arr = in.readLine().split(" ");
            switch (arr[0]) {
                case "push":
                    q[idx++] = Integer.parseInt(arr[1]);
                    break;
                case "pop":
                    idx--;
                    break;
                case "empty":
                    out.write(idx > 0 ? "NO" : "YES");
                    out.write('\n');
                    break;
                case "query":
                    out.write(String.valueOf(q[idx - 1]));
                    out.write('\n');
                    break;
            }
            out.flush();
        }
    }
}