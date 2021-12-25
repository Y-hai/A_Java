package Week5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _1 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int ans = 0;
        for (int i = 0; i <= 19; i++) {
            ans += Math.pow(2, i);
        }
        int a = ans;
        int b = (int) Math.pow(2, 19);
        int tmp = gcd(a, b);
        out.write(Integer.toString(a / tmp));
        out.write('/');
        out.write(Integer.toString(b / tmp));
        out.flush();
    }

    // 最大公因数
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
