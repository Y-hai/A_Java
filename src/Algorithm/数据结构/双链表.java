package Algorithm.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 双链表 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = (int) 1e5 + 10;
    static int idx, e[] = new int[N], l[] = new int[N], r[] = new int[N];

    static {
        idx = 2;
        r[0] = 1;
        l[1] = 0;
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- != 0) {
            String[] arr = in.readLine().split(" ");
            String op = arr[0];
            if (op.equals("L")) {
                int x = Integer.parseInt(arr[1]);
                add(0, x);
            } else if (op.equals("R")) {
                int x = Integer.parseInt(arr[1]);
                add(l[1], x);
            } else if (op.equals("D")) {
                int k = Integer.parseInt(arr[1]);
                remove(k + 1);
            } else if (op.equals("IL")) {
                int k = Integer.parseInt(arr[1]);
                int x = Integer.parseInt(arr[2]);
                add(l[k + 1], x);
            } else if (op.equals("IR")) {
                int k = Integer.parseInt(arr[1]);
                int x = Integer.parseInt(arr[2]);
                add(k + 1, x);
            }
        }
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
//先把结点创建出来，再调整指针
    private static void add(int k, int x) {
        e[idx] = x;
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
