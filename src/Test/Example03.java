package Test;

public class Example03 {
    public static void main(String[] args) {
        String[] arr = "47.108.250.212".split("\\."); // split传入的是正则表达式类型
        for (String s : arr)
            System.out.println(s);
    }
}
