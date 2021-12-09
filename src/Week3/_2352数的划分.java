package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2352数的划分 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 8;
    static int n, k, cnt;
    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);
        q[0] = 1;   // 从一开始
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int u) {
        if(u==k){
            if (n >= q[u-1]) cnt++;
            return;
        }
        for (int i = q[u - 1]; i <= n; i++) { // 可以剪枝
            q[u] = i;
            n -= i;
            dfs(u + 1);
            n += i;
        }
    }
}
