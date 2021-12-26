package Algorithm.数据结构;

import java.io.*;

public class 食物链 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 5e4 + 10;
    static int[] q = new int[N], d = new int[N];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        for (int i = 1; i <= n; i++) q[i] = i;
        while (m-- > 0) {
            arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            if (b > n || c > n) {
                cnt++;
                continue;
            }
            int pb = find(b), pc = find(c);
            if (a == 1) {
                if (pb == pc && (d[b] - d[c]) % 3 != 0) cnt++;
                else if (pb != pc) {
                    q[pb] = pc;
                    d[pb] = d[c] - d[b];
                }
            } else {
                if (pb == pc && (d[b] - d[c] - 1) % 3 != 0) cnt++;
                else if (pb != pc) {
                    q[pb] = pc;
                    d[pb] = d[c] + 1 - d[b];
                }
            }
        }
        out.write(Integer.toString(cnt));
        out.flush();
    }

    private static int find(int x) {
        if (x != q[x]) {
            int t = find(q[x]);
            d[x] += d[q[x]];
            q[x] = t;
        }
        return q[x];
    }
}
