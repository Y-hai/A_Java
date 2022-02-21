package test5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 第九届省赛B组B题

public class B方格计数 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    //将网格想象成一个坐标系，然后遍历坐标系的每一个点，最终即为方格的数目
    //为了简化运算，我们只计算第一象限中的方格数目，最终结果乘四即为解。
    public static void main(String[] args) throws IOException {
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                if (Math.sqrt(i * i + j * j) <= 1000) count++;
            }
        }
        out.write(String.valueOf(count * 4));
        out.flush();
    }
}
