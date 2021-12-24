package Algorithm.数据结构;

import java.io.*;

public class 模拟队列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = (int) 1e5 + 10;
    static int hh, tt, q[] = new int[N];

    static {
        hh = 0;
        tt = 0;
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            String[] arr = in.readLine().split(" ");
            switch (arr[0]) {
                case "push":
                    q[hh++] = Integer.parseInt(arr[1]);
                    break;
                case "pop":
                    tt++;
                    break;
                case "empty":
                    out.write(hh == tt ? "YES" : "NO");
                    out.write('\n');
                    break;
                case "query":
                    out.write(Integer.toString(q[tt]));
                    out.write('\n');
                    break;
            }
        }
        out.flush();
    }
}
