package 基础算法.二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _789数的范围 {
    static final int N = (int) 1e5 + 10;
    static int[] a = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int q = Integer.parseInt(arr[1]);
        String[] str = in.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(str[i]);

        while (q-- > 0) {
            int k = Integer.parseInt(in.readLine());
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] >= k) r = mid;
                else l = mid + 1;
            }
            int left = l;
            if (a[l] != k)
                System.out.println("-1 -1");
            else {
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] <= k) l = mid;
                    else r = mid - 1;
                }
                System.out.println(left + " " + l);
            }
        }
    }
}
