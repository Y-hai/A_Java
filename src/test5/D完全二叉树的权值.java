package test5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//https://www.lanqiao.cn/problems/183/learning/

public class D完全二叉树的权值 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int[] tree = new int[N];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(str[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int level = 1; // 当前深度
        int max = tree[0];
        int ans = level; // min level
        /**
         * 循环开始时队列中存储的是第一层的所有结点，for循环遍历第一层的所有结点（遍历到会弹出），
         * 将每个结点的左右子节点（若存在）的权值加到temp变量，同时将左右子节点插入队列尾部
         * 第一次循环结束后，队列中的结点全为第二层的结点，temp的值就是第二层的权值和
         * 比较大小，更新答案进入下一次循环，直到队列为空，说明下一层没有结点，循环结束，输出答案
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;

            for (int i = 0; i < size; i++) {
                int root = queue.poll();
                temp += tree[root];

                int left = (root << 1) + 1;
                if (left < n) {
                    queue.offer(left);
                }

                int right = (root << 1) + 2;
                if (right < n) {
                    queue.offer(right);
                }
            }

            if (temp > max) {
                max = temp;
                ans = level;
            }

            level++;
        }
        out.write(String.valueOf(ans));
        out.flush();
    }
}
