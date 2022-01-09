package Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Example07 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileReader reader = new FileReader("./src/aaa.properties");
        Properties pro = new Properties(); // 本质是一个Map集合
        pro.load(reader);
        System.out.println(pro.getProperty("name"));
        System.out.println(pro.getProperty("passwd"));
    }
}
