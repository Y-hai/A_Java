package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2352数的划分 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 8;     // 最多划分7次
    static int n, k, cnt;       // cnt代表有多少种分法
    static int[] q = new int[N];    // 存储每次的划分结果

    // 思路：分法不能重复？不妨使得划分是有序的
    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);
        q[0] = 1;   // 最小为1，从大于等于1开始划分
        dfs(1);   // 开始划分第一个数
        System.out.println(cnt);
    }
    // dfs强调的是一种搜索顺序
    private static void dfs(int u) {
        if(u==k){
            // 判断最后一次划分是否合理
            if (n >= q[u-1]) cnt++;
            return;
        }
        // 第u次划分的数字必须大于等于第u-1次划分的数字，这样才能保证有序
        for (int i = q[u - 1]; i <= n; i++){
            q[u] = i;
            n -= i; // 划分出去
            dfs(u + 1);
            n += i; // 回溯
        }
    }
}
