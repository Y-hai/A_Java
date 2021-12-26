package Algorithm.数据结构;

import java.io.*;

public class 合并集合 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int[] q = new int[N];
    static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        for (int i = 1; i <= n; i++) {
            q[i] = i;
        }
        while (m-- > 0) {
            arr = in.readLine().split(" ");
            a = Integer.parseInt(arr[1]);
            b = Integer.parseInt(arr[2]);
            switch (arr[0]) {
                case "M": // 集合合并
                    if (find(a) != find(b)) q[find(a)] = find(b);
                    break;
                case "Q": // 集合查询
                    if (find(a) == find(b)) out.write("Yes\n");
                    else out.write("No\n");
                    break;
            }
        }
        out.flush();
    }

    private static int find(int x) {
        return x == q[x] ? q[x] : (q[x] = find(q[x]));
    }
}
