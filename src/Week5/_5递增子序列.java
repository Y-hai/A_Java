package Week5;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _5递增子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q[] = new int[20];
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(arr[i]);

        dfs(q, 0, new Stack<>(), -0x3f3f3f3f);

        out.write(Integer.toString(res.size()));
        out.flush();
    }

    static private void dfs(int[] q, int index, Stack<Integer> stack, int minn) {
        if (index == n) {
            if (stack.size() >= 2) res.add(new ArrayList<>(stack)); // 不能直接追加sack
            return;
        }
        //选择nums[index]
        if (q[index] >= minn) {
            stack.push(q[index]);
            dfs(q, index + 1, stack, q[index]);
            stack.pop();
        }
        // 第一个选了，第二个不能不选(就是说必须选，不然会重复)
        if (q[index] != minn) dfs(q, index + 1, stack, minn);
    }
}
