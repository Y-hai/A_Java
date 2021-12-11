package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// IP地址是32位2进制数字，常用四段点分十进制数表示
public class _1116IP判断 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = in.readLine();
            // 判断输入是否终止
            if (s.equals("End of file"))
                break;
            // 开头不能为'.'
            if (s.charAt(0) == '.'){
                System.out.println("N");
                continue;
            }
            String[] ip = s.split("\\.");
            // 分隔后长度必须为4
            if (ip.length != 4){
                System.out.println("N");
                continue;
            }
            // 四个数字都要满足格式要求
            int count = 0;
            for (int i = 0; i < ip.length; i++) {
                if (!check(ip[i])) {
                    System.out.println("N");
                    break;
                }
                // 把String类型的ip转化为int类型进行判断
                int m = Integer.parseInt(ip[i]);
                // 数字大小必须位于0~255之间
                if (m >= 0 && m <= 255) {
                    count++;
                } else {
                    System.out.println("N");
                    break;
                }
            }
            // 如果上述条件都满足，且4个数字都符合格式要求，输出Y
            if (count == 4) {
                System.out.println("Y");
            }
        }
    }

    public static boolean check(String ip) {
        // 不能为空
        if (ip.equals(""))
            return false;
        // 不能有前导零
        if (ip.charAt(0) == '0' && ip.length() != 1)
            return false;
        // 每个字符都要在'0'~'9'之间
        for (int i = 0; i < ip.length(); i++)
            if (!(ip.charAt(i) >= '0' && ip.charAt(i) <= '9'))
                return false;
        // 全部满足说明符合格式要求
        return true;
    }
}