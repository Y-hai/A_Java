package Algorithm.数据结构;

import java.io.*;

public class 单调栈 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int q[] = new int[N], idx = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(arr[i]);
            while (idx > 0 && q[idx - 1] >= x) idx--;
            out.write((idx == 0 ? -1 : q[idx - 1]) + " ");
            q[idx++] = x;
        }
        out.flush();
    }
}
