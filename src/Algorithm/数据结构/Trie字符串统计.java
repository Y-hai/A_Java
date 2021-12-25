package Algorithm.数据结构;

import java.io.*;

public class Trie字符串统计 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int son[][] = new int[N][26], cnt[] = new int[N], idx;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            String[] arr = in.readLine().split(" ");
            if (arr[0].equals("I")) {
                insert(arr[1].toCharArray());
            } else {
                out.write(Integer.toString(query(arr[1].toCharArray())));
                out.write('\n');
            }
        }
        out.flush();
    }

    private static int query(char[] a) {
        int p = 0;
        for (int i = 0; i < a.length; i++) {
            int u = a[i] - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }

    private static void insert(char[] a) {
        int p = 0;
        for (int i = 0; i < a.length; i++) {
            int u = a[i] - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
}
