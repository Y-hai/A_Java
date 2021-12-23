package Algorithm.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 模拟栈 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = (int) 1e5 + 10;
    static int M, q[] = new int[N], idx = 0;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            String[] arr = in.readLine().split(" ");
            String op = arr[0];
            if (op.equals("push")) {
                q[idx++] = Integer.parseInt(arr[1]);
            } else if (op.equals("pop")) {
                idx--;
            } else if (op.equals("empty")) {
                System.out.println(idx > 0 ? "NO" : "YES");
            } else {
                System.out.println(q[idx - 1]);
            }
        }
    }
}
