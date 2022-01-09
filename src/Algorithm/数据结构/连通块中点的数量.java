package Algorithm.数据结构;

import java.io.*;

public class 连通块中点的数量 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int[] cnt = new int[N], q = new int[N];
    static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        for (int i = 1; i <= n; i++) {
            q[i] = i;
            cnt[i] = 1;
        }
        while (m-- > 0) {
            arr = in.readLine().split(" ");
            switch (arr[0]) {
                case "C":
                    a = Integer.parseInt(arr[1]);
                    b = Integer.parseInt(arr[2]);
                    if (find(a) != find(b)) {
                        // 次使用find(x)都是一种路径压缩，下面这两行代码不能交换顺序
                        cnt[find(b)] += cnt[find(a)];
                        q[find(a)] = find(b);
                    }
                    break;
                case "Q1":
                    a = Integer.parseInt(arr[1]);
                    b = Integer.parseInt(arr[2]);
                    out.write(find(a) == find(b) ? "Yes\n" : "No\n");
                    break;
                case "Q2":
                    a = Integer.parseInt(arr[1]);
                    out.write(Integer.toString(cnt[find(a)]));
                    out.write('\n');
                    break;
            }
        }
        out.flush();
    }

    private static int find(int x) {
        return x == q[x] ? q[x] : (q[x] = find(q[x]));
    }
}
