package Algorithm.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 模拟队列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = (int) 1e5 + 10;
    static int hh, tt, q[] = new int[N];

    static {
        hh = 0;
        tt = 0;
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            String[] arr = in.readLine().split(" ");
            String op = arr[0];
            switch (op) {
                case "push":
                    q[hh++] = Integer.parseInt(arr[1]);
                    break;
                case "pop":
                    tt++;
                    break;
                case "empty":
                    System.out.println(hh == tt ? "YES" : "NO");
                    break;
                case "query":
                    System.out.println(q[tt]);
                    break;
            }
        }
    }
}
