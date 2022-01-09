package Algorithm.数据结构;

import java.io.*;

public class 双链表 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int idx, e[] = new int[N], l[] = new int[N], r[] = new int[N];

    // 先把队头队尾定义好
    static {
        idx = 2;
        r[0] = 1;
        l[1] = 0;
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- != 0) {
            String[] arr = in.readLine().split(" ");
            int k, x;
            // 1e5级别switch比if else慢50ms，应该是JVM把switch优化成if else了
            switch (arr[0]) {
                case "L":
                    x = Integer.parseInt(arr[1]);
                    add(0, x);
                    break;
                case "R":
                    x = Integer.parseInt(arr[1]);
                    add(l[1], x);
                    break;
                case "D":
                    k = Integer.parseInt(arr[1]);
                    remove(k + 1);
                    break;
                case "IL":
                    k = Integer.parseInt(arr[1]);
                    x = Integer.parseInt(arr[2]);
                    add(l[k + 1], x);
                    break;
                case "IR":
                    k = Integer.parseInt(arr[1]);
                    x = Integer.parseInt(arr[2]);
                    add(k + 1, x);
                    break;
            }
        }
        for (int i = r[0]; i != 1; i = r[i]) {
            out.write(String.valueOf(e[i]));
            out.write(" ");
        }
        out.flush();
    }

    private static void add(int k, int x) {
        e[idx] = x; //先把结点创建出来，再调整指针
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }

    private static void remove(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }
}
