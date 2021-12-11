package Week3;

import java.util.Scanner;

public class _1021迭代法求平方根 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double a = n / 2, b = 0;
        while (Math.abs(a - b) >= 0.00001) {
            // 迭代
            b = a;
            a = (b + n / b) / 2;
        }
        // 格式控制输出
        System.out.printf("%.3f", a);
    }
}
