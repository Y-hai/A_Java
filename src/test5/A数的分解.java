package test5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//https://www.lanqiao.cn/problems/606/learning/

public class A数的分解 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = 0;
        int k;

        for (int i = 1; i <= 2019; i++)
            for (int j = i + 1; j <= 2019; j++) {
                k = 2019 - i - j;
                if (k > 0 && (i != j && i != k && j != k) && (i < j && j < k)) {
                    if (fun(i) && fun(j) && fun(k))
                        num++;
                }
            }
        out.write(String.valueOf(num));
        out.flush();
    }

    public static boolean fun(int n) {
        int m;
        while (n != 0) {
            m = n % 10;
            if (m == 2 || m == 4)
                return false;
            n = n / 10;
        }
        return true;
    }

}
