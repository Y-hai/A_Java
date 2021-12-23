package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 堆排序 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, cnt;
    static int N = (int) 1e3 + 10;
    static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        arr = in.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            p[i + 1] = Integer.parseInt(arr[i]);
        }
        cnt = n;
        for (int i = n / 2; i > 0; i--) {
            down(i);
        }
        while (m-- > 0) {
            arr = in.readLine().split(" ");
            if (arr[3].equals("root")) {
                if (Integer.parseInt(arr[0]) != p[1]) {
                    System.out.println('F');
                } else {
                    System.out.println('T');
                }
            } else if (arr[4].equals("siblings")) {

            } else if (arr[3].equals("parent")) {

            } else if (arr[3].equals("child")) {

            }

        }
    }

    static void down(int u) {
        int t = u;
        if (u * 2 <= cnt && p[u * 2] < p[t])
            t = u * 2;
        if (u * 2 + 1 <= cnt && p[u * 2 + 1] < p[t])
            t = u * 2 + 1;
        if (u != t) {
            int tmp = p[u];
            p[u] = p[t];
            p[t] = tmp;
            down(t);
        }
    }
}
