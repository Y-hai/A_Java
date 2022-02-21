package test5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

//https://www.lanqiao.cn/problems/1658/learning/

public class C不同子串 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> set = new HashSet<>();

    //暴力枚举所有起点和终点，将枚举到的字符串放入HashSet去重，最终HashSet的容量即为答案
    public static void main(String[] args) throws IOException {
        StringBuilder s = new StringBuilder("0100110001010001");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        System.out.println(String.valueOf(set.size()));
        out.flush();
    }
}
