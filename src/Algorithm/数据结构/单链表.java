package Algorithm.数据结构;

import java.io.*;

public class 单链表 {
    static final int N = (int) 1e5 + 10;
    static int head, idx, e[] = new int[N], ne[] = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static {
        head = -1;
        idx = 0;
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- != 0) {
            String[] arr = in.readLine().split(" ");
            if (arr[0].equals("H")) {
                add_to_head(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("D")) {
                if (Integer.parseInt(arr[1]) == 0)
                    head = ne[head];
                else
                    remove(Integer.parseInt(arr[1]) - 1);
            } else if (arr[0].equals("I")) {
                add(Integer.parseInt(arr[1]) - 1, Integer.parseInt(arr[2]));
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            out.write(e[i] + " ");
        }
        out.flush();
    }

    // insert x to after k
    static private void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    //    delete values after k
    static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    //     x add to head
    static private void add_to_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }
}
