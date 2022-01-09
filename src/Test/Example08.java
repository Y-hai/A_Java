package Test;

public class Example08 {
    public static void main(String[] args) {
// Integer取值范围为-128~127范围的数字已经在类加载时初始化到整型常量池
        Integer a = -129;
        Integer b = -129;
        System.out.println(a == b);
    }
}
