package Algorithm.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 链表的反转 {
    // 静态变量、代码块、编译的冗余部分、常量池在方法区
    static final int N = (int) 1e5 + 10;
    static int head, idx, e[] = new int[N], ne[] = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

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
        // 利用临时变量构建反向指针
        int[] re = new int[N];
        int tmp = -1;
        for (int i = head; i != -1; i = ne[i]) {
            re[i] = tmp;
            tmp = i;
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
        System.out.println();
        for (int i = tmp; i != -1; i = re[i]) {
            System.out.print(e[i] + " ");
        }
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
