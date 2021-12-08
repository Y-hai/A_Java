package Week3;

import java.util.Scanner;

public class _1116IP判断 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNext()) {
            String[] ip = sc.nextLine().split("\\.");
            int count = 0;
            for (int i = 0; i < ip.length; i++) {
                if (!check(ip[i])) {
                    System.out.println("N");
                    break;
                }
                // 把String类型的ip转化为int类型进行判断
                int m = Integer.parseInt(ip[i]);
                if (m >= 0 && m <= 255) {
                    count++;
                } else {
                    System.out.println("N");
                    break;
                }
            }
            if (count == 4) {
                System.out.println("Y");
            }
        }
    }

    public static boolean check(String ip) {
        if (ip.equals(""))
            return false;

        if (ip.charAt(0) == '0')
            return false;

        for (int i = 0; i < ip.length(); i++)
            if (!(ip.charAt(i) >= '0' && ip.charAt(i) <= '9'))
                return false;

        return true;
    }
}